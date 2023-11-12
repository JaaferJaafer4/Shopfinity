package tn.esprit.myapplication.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tn.esprit.myapplication.items.ChatMessageModel;


public class SQLiteManager extends SQLiteOpenHelper
{
    private static SQLiteManager sqLiteManager;

    private static final String DATABASE_NAME = "ChatDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Messages";
    private static final String COUNTER = "Counter";

    private static final String ID_FIELD = "id";
    private static final String MESSAGE_FIELD = "message";
    private static final String SENDER_FIELD = "senderId";
    private static final String RECEIVER_FIELD = "receiverId";
    private static final String TIME_FIELD = "time";

    @SuppressLint("SimpleDateFormat")
    private static final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");

    public SQLiteManager(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static SQLiteManager instanceOfDatabase(Context context)
    {
        if(sqLiteManager == null)
            sqLiteManager = new SQLiteManager(context);

        return sqLiteManager;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        StringBuilder sql;
        sql = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABLE_NAME)
                .append("(")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(ID_FIELD)
                .append(" INT, ")
                .append(MESSAGE_FIELD)
                .append(" TEXT, ")
                .append(SENDER_FIELD)
                .append(" INT, ")
                .append(RECEIVER_FIELD)
                .append(" INT ,")
                .append(TIME_FIELD)
                .append(" DATE)");

        sqLiteDatabase.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion)
    {
//        switch (oldVersion)
//        {
//            case 1:
//                sqLiteDatabase.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + NEW_COLUMN + " TEXT");
//            case 2:
//                sqLiteDatabase.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + NEW_COLUMN + " TEXT");
//        }
    }

    public void addMessageToDatabase(ChatMessageModel message)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, message.getId());
        contentValues.put(MESSAGE_FIELD, message.getMessage());
        contentValues.put(SENDER_FIELD, message.getSenderId());
        contentValues.put(RECEIVER_FIELD, message.getReceiverId());
        contentValues.put(TIME_FIELD, message.getTime().getTime());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public void populateNoteListArray()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null))
        {
            if(result.getCount() != 0)
            {
                while (result.moveToNext())
                {
                    int id = result.getInt(1);
                    String message = result.getString(2);
                    int sender = result.getInt(3);
                    int receiver = result.getInt(4);
                    long timestampMillis = result.getLong(5);

                    Date time = new Date(timestampMillis);
                    ChatMessageModel messageModel = new ChatMessageModel(id,message,sender,receiver,time);
                    ChatMessageModel.messageArrayList.add(messageModel);
                }
            }
        }
    }

    public void updateMessageInDB(ChatMessageModel chatMessageModel)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, chatMessageModel.getId());
        contentValues.put(MESSAGE_FIELD, chatMessageModel.getMessage());
        contentValues.put(SENDER_FIELD, chatMessageModel.getSenderId());
        contentValues.put(RECEIVER_FIELD, chatMessageModel.getReceiverId());
        contentValues.put(TIME_FIELD, chatMessageModel.getTime().getTime());

        sqLiteDatabase.update(TABLE_NAME, contentValues, ID_FIELD + " =? ", new String[]{String.valueOf(chatMessageModel.getId())});
    }


}

















