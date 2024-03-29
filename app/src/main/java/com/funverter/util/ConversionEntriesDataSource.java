package com.funverter.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.funverter.helper.MySQLiteHelper;

import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by edmar on 2/15/15.
 * This class is our DAO. It maintains the database connection and supports adding new values
 * and fetching all values.
 */
public class ConversionEntriesDataSource {

    // Database fields
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_VALUES };

    public ConversionEntriesDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ConversionEntry createConversionEntry(String conversionEntry, String tableName) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_VALUES, conversionEntry);
        long insertId;
        Cursor cursor;
        ConversionEntry entry = null;

        try{
            insertId = database.insertOrThrow(tableName, null, values);
            cursor = database.query(tableName,
                    allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                    null, null, null);
            cursor.moveToFirst();
            entry = cursorToConversionEntry(cursor);
            cursor.close();
        } catch(SQLiteConstraintException e) {
            Log.e(this.getClass().getName(), "Error inserting " + values + " into " +
                    tableName + ". Probably because the value is not unique.", e);
        }

        return entry;
    }

    public void deleteTableConversionEntry(ConversionEntry conversionEntry, String tableName) {
        long id = conversionEntry.getId();
        database.delete(tableName, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
        System.out.println("Value deleted with id: " + id);
    }

    public void deleteAllTableConversionEntries(String tableName) {
        database.delete(tableName, null, null);
        System.out.println("Deleted all values from table: " + tableName);
    }

    public void deleteAllConversionEntries() {
        System.out.println("Deleting all conversion values from all tables...");
        for(String tableName : MySQLiteHelper.tableNames) {
            database.delete(tableName, null, null);
        }
        System.out.println("Deleted all conversion values from all tables");
    }

    public List<ConversionEntry> getAllTableConversionEntries(String tableName) {
        List<ConversionEntry> conversionEntries = new ArrayList<>();
        Cursor cursor = getCursor(tableName);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ConversionEntry comment = cursorToConversionEntry(cursor);
            conversionEntries.add(comment);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return conversionEntries;
    }

    public List<ConversionEntry> getAllConversionEntries() {
        List<ConversionEntry> conversionEntries = new ArrayList<>();

        Cursor cursor = database.query(null,
                new String[]{MySQLiteHelper.COLUMN_VALUES}, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ConversionEntry entry = cursorToConversionEntry(cursor);
            conversionEntries.add(entry);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return conversionEntries;
    }

    private ConversionEntry cursorToConversionEntry(Cursor cursor) {
        ConversionEntry conversionEntry = new ConversionEntry();
        conversionEntry.setId(cursor.getLong(0));
        conversionEntry.setValue(cursor.getString(1));
        return conversionEntry;
    }

    public Cursor getCursor(String tableName) {
        dbHelper.createTable(database, tableName);
        Cursor cursor = database.rawQuery("SELECT * FROM " + tableName, null);
        return cursor;
    }
}
