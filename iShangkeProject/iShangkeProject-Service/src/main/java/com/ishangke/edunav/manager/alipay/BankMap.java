package com.ishangke.edunav.manager.alipay;

import java.util.HashMap;
import java.util.Map;

public class BankMap {
    public static Map<String, String> BANK_MAP;
    static {
        BANK_MAP = new HashMap<String, String>();
        BANK_MAP.put("ICBC-DEBIT","ICBC-DEBIT");
        BANK_MAP.put("GDB-DEBIT","GDB-DEBIT");
        BANK_MAP.put("CIB","CIB");
        BANK_MAP.put("CCB-DEBIT","CCB-DEBIT");
        BANK_MAP.put("COMM","COMM");
        BANK_MAP.put("SPDB-DEBIT","SPDB-DEBIT");
        BANK_MAP.put("SHRCB","SHRCB");
        BANK_MAP.put("FDB","FDB");
        BANK_MAP.put("PSBC-DEBIT","PSBC-DEBIT");
        BANK_MAP.put("BOC-DEBIT","BOC-DEBIT");
        BANK_MAP.put("BJRCB","BJRCB");
        BANK_MAP.put("SPABANK","SPABANK");
        BANK_MAP.put("SHBANK","SHBANK");
        BANK_MAP.put("NBBANK","NBBANK");
        BANK_MAP.put("CEB-DEBIT","CEB-DEBIT");
        BANK_MAP.put("CMB-DEBIT","CMB-DEBIT");
        BANK_MAP.put("CITIC","CITIC");
        BANK_MAP.put("ABC","ABC");
        BANK_MAP.put("WZCBB2C-DEBIT","WZCBB2C-DEBIT");
        BANK_MAP.put("BJBANK","BJBANK");
        BANK_MAP.put("HZCBB2C","HZCBB2C");
        BANK_MAP.put("CMBC","CMBC");
    }
}
