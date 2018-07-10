package com.polidea.cockpitplugin.generator

import com.polidea.cockpit.core.CockpitParam
import com.polidea.cockpit.core.ParamType
import kotlin.test.Test
import kotlin.test.assertEquals


class DebugCockpitGeneratorTest {

    private val cockpitGenerator = DebugCockpitGenerator()

    @Test
    fun createGetterMethodSpecForDoubleParamTest() {
        val doubleGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForParam(CockpitParam("doubleParam", 3.0))

        val expectedDoubleGetterMethodSpecString = """
            |public static double getDoubleParam() {
            |  return (double) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("doubleParam");
            |}"""
        assertEquals(expectedDoubleGetterMethodSpecString.trimMargin(), doubleGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForDoubleParamTest() {
        val doubleSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam(CockpitParam("doubleParam", 3.0))

        val expectedDoubleSetterMethodSpecString = """
            |public static void setDoubleParam(double doubleParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("doubleParam", doubleParam);
            |}"""
        assertEquals(expectedDoubleSetterMethodSpecString.trimMargin(), doubleSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForIntParamTest() {
        val intGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForParam(CockpitParam("integerParam", 2))

        val expectedIntegerGetterMethodSpecString = """
            |public static int getIntegerParam() {
            |  return (int) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("integerParam");
            |}"""
        assertEquals(expectedIntegerGetterMethodSpecString.trimMargin(), intGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForIntParamTest() {
        val intSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam(CockpitParam("integerParam", 2))

        val expectedDoubleSetterMethodSpecString = """
            |public static void setIntegerParam(int integerParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("integerParam", integerParam);
            |}"""
        assertEquals(expectedDoubleSetterMethodSpecString.trimMargin(), intSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForBooleanParamTest() {
        val booleanGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForParam(CockpitParam("booleanParam", false))

        val expectedBooleanGetterMethodSpecString = """
            |public static boolean isBooleanParam() {
            |  return (boolean) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("booleanParam");
            |}"""
        assertEquals(expectedBooleanGetterMethodSpecString.trimMargin(), booleanGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForBooleanParamTest() {
        val booleanSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam(CockpitParam("booleanParam", false))

        val expectedBooleanSetterMethodSpecString = """
            |public static void setBooleanParam(boolean booleanParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("booleanParam", booleanParam);
            |}"""
        assertEquals(expectedBooleanSetterMethodSpecString.trimMargin(), booleanSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createGetterMethodSpecForStringParamTest() {
        val stringGetterMethodSpec = cockpitGenerator.createGetterMethodSpecForParam(CockpitParam("stringParam", "testValue"))

        val expectedStringGetterMethodSpecString = """
            |public static java.lang.String getStringParam() {
            |  return (java.lang.String) com.polidea.cockpit.manager.CockpitManager.INSTANCE.getParamValue("stringParam");
            |}"""
        assertEquals(expectedStringGetterMethodSpecString.trimMargin(), stringGetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createSetterMethodSpecForStringParamTest() {
        val stringSetterMethodSpec = cockpitGenerator.createSetterMethodSpecForParam(CockpitParam("stringParam", "testValue"))

        val expectedStringSetterMethodSpecString = """
            |public static void setStringParam(java.lang.String stringParam) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.setParamValue("stringParam", stringParam);
            |}"""
        assertEquals(expectedStringSetterMethodSpecString.trimMargin(), stringSetterMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForBooleanParamTest() {
        val booleanParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForParam(CockpitParam("boolParam", false))

        val expectedBooleanParamChangeListenerMethodSpecString = """
            |public static void addOnBoolParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<? extends java.lang.Boolean> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("boolParam", listener);
            |}"""
        assertEquals(expectedBooleanParamChangeListenerMethodSpecString.trimMargin(), booleanParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForIntParamTest() {
        val integerParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForParam(CockpitParam("intParam", 0))

        val expectedIntegerParamChangeListenerMethodSpecString = """
            |public static void addOnIntParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<? extends java.lang.Integer> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("intParam", listener);
            |}"""
        assertEquals(expectedIntegerParamChangeListenerMethodSpecString.trimMargin(), integerParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForDoubleParamTest() {
        val doubleParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForParam(CockpitParam("doubleParam", .0))

        val expectedDoubleParamChangeListenerMethodSpecString = """
            |public static void addOnDoubleParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<? extends java.lang.Double> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("doubleParam", listener);
            |}"""
        assertEquals(expectedDoubleParamChangeListenerMethodSpecString.trimMargin(), doubleParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddParamChangeListenerMethodSpecForStringParamTest() {
        val stringParamChangeListenerMethodSpec = cockpitGenerator.createAddPropertyChangeListenerMethodSpecForParam(CockpitParam("stringParam", ""))

        val expectedStringParamChangeListenerMethodSpecString = """
            |public static void addOnStringParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<? extends java.lang.String> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addOnParamChangeListener("stringParam", listener);
            |}"""
        assertEquals(expectedStringParamChangeListenerMethodSpecString.trimMargin(), stringParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForBooleanParamTest() {
        val booleanParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForParam(CockpitParam("boolParam", false))

        val expectedBooleanParamChangeListenerMethodSpecString = """
            |public static void removeOnBoolParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<? extends java.lang.Boolean> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("boolParam", listener);
            |}"""
        assertEquals(expectedBooleanParamChangeListenerMethodSpecString.trimMargin(), booleanParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForIntParamTest() {
        val integerParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForParam(CockpitParam("intParam", 0))

        val expectedIntegerParamChangeListenerMethodSpecString = """
            |public static void removeOnIntParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<? extends java.lang.Integer> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("intParam", listener);
            |}"""
        assertEquals(expectedIntegerParamChangeListenerMethodSpecString.trimMargin(), integerParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForDoubleParamTest() {
        val doubleParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForParam(CockpitParam("doubleParam", .0))

        val expectedDoubleParamChangeListenerMethodSpecString = """
            |public static void removeOnDoubleParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<? extends java.lang.Double> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("doubleParam", listener);
            |}"""
        assertEquals(expectedDoubleParamChangeListenerMethodSpecString.trimMargin(), doubleParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveParamChangeListenerMethodSpecForStringParamTest() {
        val stringParamChangeListenerMethodSpec = cockpitGenerator.createRemovePropertyChangeListenerMethodSpecForParam(CockpitParam("stringParam", ""))

        val expectedStringParamChangeListenerMethodSpecString = """
            |public static void removeOnStringParamChangeListener(
            |    com.polidea.cockpit.event.PropertyChangeListener<? extends java.lang.String> listener) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeOnParamChangeListener("stringParam", listener);
            |}"""
        assertEquals(expectedStringParamChangeListenerMethodSpecString.trimMargin(), stringParamChangeListenerMethodSpec.toString().trimMargin())
    }

    @Test
    fun createAddActionCallbackMethodSpecForStringParamTest() {
        val actionCallbackMethodSpec = cockpitGenerator.createAddActionCallbackMethodSpecForParam(CockpitParam("value", "show", ParamType.ACTION))

        val expectedActionCallbackMethodSpecString = """
            |public static void addValueActionCallback(com.polidea.cockpit.event.ActionCallback callback) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.addActionCallback("value", callback);
            |}"""
        System.out.println("Expected:\n${expectedActionCallbackMethodSpecString.trimMargin()}")
        System.out.println("Given   :\n${actionCallbackMethodSpec.toString().trimMargin()}")
        assertEquals(expectedActionCallbackMethodSpecString.trimMargin(), actionCallbackMethodSpec.toString().trimMargin())
    }

    @Test
    fun createRemoveActionCallbackMethodSpecForStringParamTest() {
        val actionCallbackMethodSpec = cockpitGenerator.createRemoveActionCallbackMethodSpecForParam(CockpitParam("value", "show", ParamType.ACTION))

        val expectedActionCallbackMethodSpecString = """
            |public static void removeValueActionCallback(com.polidea.cockpit.event.ActionCallback callback) {
            |  com.polidea.cockpit.manager.CockpitManager.INSTANCE.removeActionCallback("value", callback);
            |}"""
        System.out.println("Expected:\n${expectedActionCallbackMethodSpecString.trimMargin()}")
        System.out.println("Given   :\n${actionCallbackMethodSpec.toString().trimMargin()}")
        assertEquals(expectedActionCallbackMethodSpecString.trimMargin(), actionCallbackMethodSpec.toString().trimMargin())
    }

    @Test
    fun generateShowCockpitMethodTest() {
        val funSpec = cockpitGenerator.generateShowCockpitMethod()

        val expectedFunSpecString = """
            |public static void showCockpit(android.support.v4.app.FragmentManager fragmentManager) {
            |  com.polidea.cockpit.paramsedition.CockpitDialog cockpitDialog = com.polidea.cockpit.paramsedition.CockpitDialog.Companion.newInstance();
            |  cockpitDialog.show(fragmentManager, "Cockpit");
            |}"""

        assertEquals(expectedFunSpecString.trimMargin(), funSpec.toString().trimMargin())
    }

    private fun getTestParams(): List<CockpitParam<*>> {
        val testParams: MutableList<CockpitParam<*>> = mutableListOf()

        testParams.add(CockpitParam("doubleParam", 3.0))
        testParams.add(CockpitParam("booleanParam", false))
        testParams.add(CockpitParam("stringParam", "testValue"))
        testParams.add(CockpitParam("integerParam", 2))

        return testParams
    }
}