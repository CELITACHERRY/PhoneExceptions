package com.codedifferently;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferently.phone.PhoneNumber;
import com.codedifferently.phone.PhoneNumberFactory;
import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberFactoryTest {

    @Test(expected = InvalidPhoneNumberFormatException.class)
    public void testInvalidPhoneNumberFormatException() throws InvalidPhoneNumberFormatException {
        PhoneNumberFactory.createPhoneNumber("-1");
    }

    @Test
    public void testCreatePhoneNumberSafely() {
        // : Given
        int areaCode = 302;
        int centralOfficeCode = 571;
        int phoneLineCode = 6548;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(null, phoneNumber);
    }

    @Test
    public void testGetAreaCode() {
        // : Given
        Integer areaCode = 302;
        int centralOfficeCode = 412;
        int phoneLineCode = 5555;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(phoneNumber.getAreaCode(), areaCode.toString());
    }

    @Test
    public void testGetCentralOfficeCode() {
        // : Given
        int areaCode = 302;
        Integer centralOfficeCode = 312;
        int phoneLineCode = 5555;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(phoneNumber.getCentralOfficeCode(), centralOfficeCode.toString());
    }


    @Test
    public void testPhoneLineCode() {
        // : Given
        int areaCode = 302;
        int centralOfficeCode = 312;
        Integer phoneLineCode = 5555;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(phoneNumber.getPhoneLineCode(), phoneLineCode.toString());
    }

    @Test
    public void testCreateRandomPhoneNumber() {
        for (int i = 0; i < 999; i++) {
            // : Given
            // : When
            PhoneNumber phoneNumber = PhoneNumberFactory.createRandomPhoneNumber();

            // : Then
            Assert.assertTrue(phoneNumber != null   );
        }
    }
}