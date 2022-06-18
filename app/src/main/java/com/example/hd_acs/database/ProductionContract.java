package com.example.hd_acs.database;

import android.provider.BaseColumns;

public class ProductionContract {

    public ProductionContract() {}

    public static final class ProductionEntry implements BaseColumns {
        //create string constants
        //name of the table
        public static final String TABLE_NAME = "productionList";

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
