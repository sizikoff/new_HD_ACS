package com.example.hd_acs.database2;

import android.provider.BaseColumns;

public class ZakazContract {

    public ZakazContract() {}

    public static final class ZakazEntry implements BaseColumns{
        //create string constants
        //name of the table
        public static final String TABLE_NAME = "zakaz";

        //name of the first column of the table
        public static final String COLUMN_NAME = "name";

        //name of the column we save the amount of an item
        public static final String COLUMN_AMOUNT = "amount";

        //name of timestamp for ordering items in the list
        public static final String COLUMN_TIMESTAMP ="timestamp";
        public static final String COLUMN_COLOR = "color";
        public static final String COLUMN_MATERIAL = "material";
    }
}
