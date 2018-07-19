package com.polidea.cockpit.paramsedition

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import com.polidea.cockpit.R
import com.polidea.cockpit.utils.getScreenHeight
import com.polidea.cockpit.utils.removeDimmedBackground

internal class CockpitDialog internal constructor() : BottomSheetDialogFragment(), ParamsEditionContract.View {

    private val peekHeight = getScreenHeight() / 2
    override lateinit var presenter: ParamsEditionContract.Presenter
    private lateinit var paramsEditionAdapter: ParamsEditionAdapter
    private lateinit var behavior: BottomSheetBehavior<View>
    private lateinit var expandCollapse: ImageButton

    override fun onStart() {
        super.onStart()
        removeDimmedBackground()
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val view = View.inflate(context, R.layout.dialog_params_edition, null)
        dialog.setContentView(view)
        setupBehavior(view)
        setupViews(view)
        presenter.start()
        retainInstance = true
        return dialog
    }

    private fun setupBehavior(view: View) {
        behavior = BottomSheetBehavior.from(view.parent as View)
        behavior.isHideable = true
        behavior.skipCollapsed = false
        behavior.peekHeight = peekHeight
        behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                animateExpandCollapseIcon(slideOffset)
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN)
                    presenter.hidden()
            }
        })
    }

    private fun animateExpandCollapseIcon(slideOffset: Float) {
        if (slideOffset >= 0)
            expandCollapse.animate().rotation(expandCollapseIconRotationDegrees * (1f - slideOffset))
    }

    private fun setupViews(view: View) {
        paramsEditionAdapter = ParamsEditionAdapter(presenter)
        view.findViewById<RecyclerView>(R.id.params_list).adapter = paramsEditionAdapter
        view.findViewById<ImageButton>(R.id.restore_defaults).setOnClickListener { presenter.restoreAll() }
        expandCollapse = view.findViewById(R.id.expand_collapse)
        expandCollapse.setOnClickListener {
            if (behavior.state == BottomSheetBehavior.STATE_COLLAPSED)
                presenter.expand()
            else if (behavior.state == BottomSheetBehavior.STATE_EXPANDED)
                presenter.collapse()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.stop()
    }

    override fun reloadParam(position: Int) {
        paramsEditionAdapter.reloadParam(position)
    }

    override fun reloadAll() {
        paramsEditionAdapter.reloadAll()
    }

    override fun expand() {
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    override fun collapse() {
        behavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    companion object {
        private const val expandCollapseIconRotationDegrees = 180

        fun newInstance(): CockpitDialog {
            val instance = CockpitDialog()
            CockpitDialogPresenter(instance)
            return instance
        }
    }
}