package com.example.hd_acs.database3;

import android.provider.BaseColumns;

public class DefectContract {

    public DefectContract() {}

    public static final class DefectEntry implements BaseColumns{
        //create string constants
        //name of the table
        public static final String TABLE_NAME = "def";

        //name of the first column of the table
        public static final String COLUMN_NAME = "name";
        //name of the column we save the amount of an item
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_EMPLOEYY = "empolyer";
        public static final String COLUMN_MODEL = "model";

        //name of timestamp for ordering items in the list
        public static final String COLUMN_TIMESTAMP ="timestamp";
        public static final String COLUMN_COLOR = "color";
        public static final String COLUMN_MATERIAL = "material";
    }
}
