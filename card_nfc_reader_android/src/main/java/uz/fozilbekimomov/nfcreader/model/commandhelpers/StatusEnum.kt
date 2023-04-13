package uz.fozilbekimomov.nfcreader.model.commandhelpers

import uz.fozilbekimomov.nfcreader.utils.BytesUtils

/**
 * List of status word (last 2 bytes) in APDU response
 * APDU - Smart card application protocol data unit
 * You can find more here:
 * https://en.wikipedia.org/wiki/Smart_card_application_protocol_data_unit
 * https://www.iso.org/standard/36134.html
 */
enum class StatusEnum(status: String, val detail: String) {

    STATUS_61(
        "61",
        "Command successfully executed; 'XX' bytes of data are available and can be requested using GET RESPONSE"
    ),
    STATUS_6200("6200", "No information given (NV-Ram not changed)"),
    STATUS_6201("6201", "NV-Ram not changed 1"),
    STATUS_6281("6281", "Part of returned data may be corrupted"),
    STATUS_6282("6282", "End of file/record reached before reading Le bytes"),
    STATUS_6283("6283", "Selected file invalidated"),
    STATUS_6284("6284", "Selected file is not valid. FCI not formated according to ISO"),
    STATUS_6285("6285", "Selected file is in termination state"),
    STATUS_62A2("62A2", "Wrong R-MAC"),
    STATUS_62A4("62A4", "Card locked (during reset( ))"),
    STATUS_62F1("62F1", "Wrong C-MAC"),
    STATUS_62F3("62F3", "Internal reset"),
    STATUS_62F5("62F5", "Default agent locked"),
    STATUS_62F7("62F7", "Cardholder locked"),
    STATUS_62F8("62F8", "Basement is current agent"),
    STATUS_62F9("62F9", "CALC Key Set not unblocked"),
    STATUS_62("62", "RFU"),
    STATUS_6300("6300", "No information given (NV-Ram changed)"),
    STATUS_6381("6381", "File filled up by the last write. Loading/updating is not allowed"),
    STATUS_6382("6382", "Card key not supported"),
    STATUS_6383("6383", "Reader key not supported"),
    STATUS_6384("6384", "Plaintext transmission not supported"),
    STATUS_6385("6385", "Secured transmission not supported"),
    STATUS_6386("6386", "Volatile memory is not available"),
    STATUS_6387("6387", "Non-volatile memory is not available"),
    STATUS_6388("6388", "Key number not valid"),
    STATUS_6389("6389", "Key length is not correct"),
    STATUS_63C0("63C0", "Verify fail, no try left"),
    STATUS_63C1("63C1", "Verify fail, 1 try left"),
    STATUS_63C2("63C2", "Verify fail, 2 tries left"),
    STATUS_63C3("63C3", "Verify fail, 3 tries left"),
    STATUS_63("63", "RFU"),
    STATUS_6400("6400", "No information given (NV-Ram not changed)"),
    STATUS_6401("6401", "Command timeout"),
    STATUS_64("64", "RFU"),
    STATUS_6500("6500", "No information given"),
    STATUS_6501(
        "6501",
        "Write error. Memory failure. There have been problems in writing or reading the EEPROM. Other hardware problems may also bring this error"
    ),
    STATUS_6581("6581", "Memory failure"),
    STATUS_65("65", "RFU"),
    STATUS_6669("6669", "Incorrect Encryption/Decryption Padding"),
    STATUS_66("66", "-"),
    STATUS_6700("6700", "Wrong length"),
    STATUS_67("67", "length incorrect (procedure)(ISO 7816-3)"),
    STATUS_6800("6800", "No information given (The request function is not supported by the card)"),
    STATUS_6881("6881", "Logical channel not supported"),
    STATUS_6882("6882", "Secure messaging not supported"),
    STATUS_6883("6883", "Last command of the chain expected"),
    STATUS_6884("6884", "Command chaining not supported"),
    STATUS_68("68", "RFU"),
    STATUS_6900("6900", "No information given (Command not allowed)"),
    STATUS_6981("6981", "Command incompatible with file structure"),
    STATUS_6982("6982", "Security condition not satisfied"),
    STATUS_6983("6983", "Authentication method blocked"),
    STATUS_6984("6984", "Referenced data reversibly blocked (invalidated)"),
    STATUS_6985("6985", "Conditions of use not satisfied"),
    STATUS_6986("6986", "Command not allowed (no current EF)"),
    STATUS_6987("6987", "Expected secure messaging (SM) object missing"),
    STATUS_6988("6988", "Incorrect secure messaging (SM) data object"),
    STATUS_6996("6996", "Data must be updated again"),
    STATUS_69F0("69F0", "Permission Denied"),
    STATUS_69F1("69F1", "Permission Denied - Missing Privilege"),
    STATUS_69("69", "RFU"),
    STATUS_6A00("6A00", "No information given (Bytes P1 and/or P2 are incorrect)"),
    STATUS_6A80("6A80", "The parameters in the data field are incorrect"),
    STATUS_6A81("6A81", "Function not supported"),
    STATUS_6A82("6A82", "File not found"),
    STATUS_6A83("6A83", "Record not found"),
    STATUS_6A84("6A84", "There is insufficient memory space in record or file"),
    STATUS_6A85("6A85", "Lc inconsistent with TLV structure"),
    STATUS_6A86("6A86", "Incorrect P1 or P2 parameter"),
    STATUS_6A87("6A87", "Lc inconsistent with P1-P2"),
    STATUS_6A88("6A88", "Referenced data not found"),
    STATUS_6A89("6A89", "File already exists"),
    STATUS_6A8A("6A8A", "DF name already exists"),
    STATUS_6AF0("6AF0", "Wrong parameter value"),
    STATUS_6A("6A", "RFU"),
    STATUS_6B00("6B00", "Wrong parameter(s) P1-P2"),
    STATUS_6B("6B", "Reference incorrect (procedure byte), (ISO 78163)"),
    STATUS_6C00("6C00", "Incorrect P3 length"),
    STATUS_6C("6C", "xx = exact Le"),
    STATUS_6D00("6D00", "Instruction code not supported or invalid"),
    STATUS_6D("6D", "Instruction code not programmed or invalid (procedure byte), (ISO 7816-3)"),
    STATUS_6E00("6E00", "Class not supported"),
    STATUS_6E("6E", "Instruction class not supported (procedure byte), (ISO 7816-3)"),
    STATUS_6F00(
        "6F00",
        "Command aborted - more exact diagnosis not possible (e.g., operating system error)"
    ),
    STATUS_6FFF("6FFF", "Card dead (overuse, …)"),
    STATUS_6F("6F", "No precise diagnosis (procedure byte), (ISO 7816-3)"),
    STATUS_9000("9000", "Command successfully executed (OK)"),
    STATUS_9004("9004", "PIN not succesfully verified, 3 or more PIN tries left"),
    STATUS_9008("9008", "Key/file not found"),
    STATUS_9080("9080", "Unblock Try Counter has reached zero"),
    STATUS_9101("9101", "States.activity, States.lock Status or States.lockable has wrong value"),
    STATUS_9102("9102", "Transaction number reached its limit"),
    STATUS_9210("9210", "No more storage available"),
    STATUS_9301("9301", "Integrity error"),
    STATUS_9302("9302", "Candidate S2 invalid"),
    STATUS_9401("9401", "Candidate currency code does not match purse currency"),
    STATUS_9402("9402", "Candidate amount too high"),
    STATUS_9403("9403", "Candidate amount too low"),
    STATUS_9405("9405", "Problems in the data field"),
    STATUS_9407("9407", "Bad currency : purse engine has no slot with R3bc currency"),
    STATUS_9408("9408", "R3bc currency not supported in purse engine"),
    STATUS_9580("9580", "Bad sequence"),
    STATUS_9681("9681", "Slave not found"),
    STATUS_9700("9700", "PIN blocked and Unblock Try Counter is 1 or 2"),
    STATUS_9702("9702", "Main keys are blocked"),
    STATUS_9704("9704", "PIN not successfully verified, 3 or more PIN tries left"),
    STATUS_9784("9784", "Base key"),
    STATUS_9785("9785", "Limit exceeded - C-MAC key"),
    STATUS_9786("9786", "SM error - Limit exceeded - R-MAC key"),
    STATUS_9787("9787", "Limit exceeded - sequence counter"),
    STATUS_9788("9788", "Limit exceeded - R-MAC length"),
    STATUS_9789("9789", "Service not available"),
    STATUS_9804("9804", "Access conditions not satisfied"),
    STATUS_9900("9900", "1 PIN try left"),
    STATUS_9904("9904", "PIN not succesfully verified, 1 PIN try left"),
    STATUS_9985("9985", "Wrong mStatus - Cardholder lock"),
    STATUS_9986("9986", "Missing privilege"),
    STATUS_9987("9987", "PIN is not installed"),
    STATUS_9988("9988", "Wrong mStatus - R-MAC state"),
    STATUS_9A00("9A00", "2 PIN try left"),
    STATUS_9A04("9A04", "PIN not succesfully verified, 2 PIN try left"),
    STATUS_9A71("9A71", "Wrong parameter value - Double agent AID"),
    STATUS_9A72("9A72", "Wrong parameter value - Double agent Type"),
    STATUS_9D05("9D05", "Incorrect certificate type"),
    STATUS_9D07("9D07", "Incorrect session data size"),
    STATUS_9D08("9D08", "Incorrect DIR file record size"),
    STATUS_9D09("9D09", "Incorrect FCI record size"),
    STATUS_9D0A("9D0A", "Incorrect code size"),
    STATUS_9D10("9D10", "Insufficient memory to load application"),
    STATUS_9D11("9D11", "Invalid AID"),
    STATUS_9D12("9D12", "Duplicate AID"),
    STATUS_9D13("9D13", "Application previously loaded"),
    STATUS_9D14("9D14", "Application history list full"),
    STATUS_9D15("9D15", "Application not open"),
    STATUS_9D17("9D17", "Invalid offset"),
    STATUS_9D18("9D18", "Application already loaded"),
    STATUS_9D19("9D19", "Invalid certificate"),
    STATUS_9D1A("9D1A", "Invalid signature"),
    STATUS_9D1B("9D1B", "Invalid KTU"),
    STATUS_9D1D("9D1D", "MSM controls not set"),
    STATUS_9D1E("9D1E", "Application signature does not exist"),
    STATUS_9D1F("9D1F", "KTU does not exist"),
    STATUS_9D20("9D20", "Application not loaded"),
    STATUS_9D21("9D21", "Invalid Open command data length"),
    STATUS_9D30("9D30", "Check data parameter is incorrect (invalid start address)"),
    STATUS_9D31("9D31", "Check data parameter is incorrect (invalid length)"),
    STATUS_9D32("9D32", "Check data parameter is incorrect (illegal memory check area)"),
    STATUS_9D40("9D40", "Invalid MSM Controls ciphertext"),
    STATUS_9D41("9D41", "MSM controls already set"),
    STATUS_9D42("9D42", "Set MSM Controls data length less than 2 bytes"),
    STATUS_9D43("9D43", "Invalid MSM Controls data length"),
    STATUS_9D44("9D44", "Excess MSM Controls ciphertext"),
    STATUS_9D45("9D45", "Verification of MSM Controls data failed"),
    STATUS_9D50("9D50", "Invalid MCD Issuer production ID"),
    STATUS_9D51("9D51", "Invalid MCD Issuer ID"),
    STATUS_9D52("9D52", "Invalid set MSM controls data date"),
    STATUS_9D53("9D53", "Invalid MCD number"),
    STATUS_9D54("9D54", "Reserved field error"),
    STATUS_9D55("9D55", "Reserved field error"),
    STATUS_9D56("9D56", "Reserved field error"),
    STATUS_9D57("9D57", "Reserved field error"),
    STATUS_9D60("9D60", "MAC verification failed"),
    STATUS_9D61("9D61", "Maximum number of unblocks reached"),
    STATUS_9D62("9D62", "Card was not blocked"),
    STATUS_9D63("9D63", "Crypto functions not available"),
    STATUS_9D64("9D64", "No application loaded"),
    STATUS_9E00("9E00", "PIN not installed"),
    STATUS_9E04("9E04", "PIN not successfully verified, PIN not installed"),
    STATUS_9F00("9F00", "PIN blocked and Unblock Try Counter is 3"),
    STATUS_9F04("9F04", "PIN not successfully verified, PIN blocked and Unblock Try Counter is 3");

    val status: ByteArray = BytesUtils.byteArrayFromString(status)

    companion object {
        fun getStatusEnumByByteArray(status: ByteArray?): StatusEnum? {
            if (status == null || status.size < 2) {
                return null
            }
            var statusEnumReturnValue: StatusEnum? = null
            for (statusEnum in values()) {
                if (statusEnum.status.size == 1 && status[status.size - 2] == statusEnum.status[0]
                    || status[status.size - 2] == statusEnum.status[0] && status[status.size - 1] == statusEnum.status[1]
                ) {
                    statusEnumReturnValue = statusEnum
                    break
                }
            }
            return statusEnumReturnValue
        }

        fun isEqual(byte: ByteArray?, enum: StatusEnum): Boolean {
            val byteEnum = getStatusEnumByByteArray(byte)
            return byteEnum != null && byteEnum == enum
        }
    }

}