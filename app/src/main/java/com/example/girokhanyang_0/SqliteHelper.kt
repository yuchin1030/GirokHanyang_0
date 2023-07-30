import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class DiaryEntry(
    val id: Long?,
    val date: String,
    val mood: ByteArray?,
    val content: String,
    val imageUri: ByteArray?
)

class SqliteHelper(context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {

    /*companion object {
        private const val DATABASE_NAME = "dDiary.db"
        private const val DATABASE_VERSION = 1

        // 테이블 이름과 열 이름들
        private const val TABLE_NAME = "diaryTBL"
        private const val COL_ID = "id"
        private const val COL_DATE = "dDate"
        private const val COL_MOOD = "dMood"
        private const val COL_CONTENT = "dContent"
        private const val COL_IMAGE_URI = "dImage"
    }*/

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE diaryEntry (" +
                "id INTEGER PRIMARY KEY, " +
                "dDate TEXT, " +
                "dMood BLOB, " +
                "dContent TEXT, " +
                "dImage BLOB" +
                ")"

        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }

    // 데이터 추가
    fun insertData(diaryEntry: DiaryEntry) {

        val values = ContentValues()
        values.put("id", diaryEntry.id)
        values.put("dDate", diaryEntry.date)
        values.put("dMood", diaryEntry.mood)
        values.put("dContent", diaryEntry.content)
        values.put("dImage", diaryEntry.imageUri)

        val wd = this.writableDatabase
        wd.insert("diaryEntry", null, values)  // 테이블에 values insert
        wd.close()
    }

    // 데이터 조회
    @SuppressLint("Range")
    fun getAllData(): MutableList<DiaryEntry> {
        val dataList = mutableListOf<DiaryEntry>()
        val rd = this.readableDatabase
        val cursor = rd.rawQuery("SELECT * FROM diaryEntry", null)
        DatabaseUtils.dumpCursor(cursor)    // 데이터베이스 확인

        while(cursor.moveToNext()) {
            val id = cursor.getLong(cursor.getColumnIndex("id"))
            val date = cursor.getString(cursor.getColumnIndex("dDate"))
            val mood : ByteArray? = cursor.getBlob(cursor.getColumnIndex("dMood"))
            val content = cursor.getString(cursor.getColumnIndex("dContent"))
            val imageUri : ByteArray? = cursor.getBlob(cursor.getColumnIndex("dImage")) ?: null

            dataList.add(DiaryEntry(id, date, mood, content, imageUri))
        }
        /*cursor?.use {
            if (it.moveToFirst()) {
                do {
                    val id = it.getInt(it.getColumnIndex("COL_ID"))
                    val date = it.getString(it.getColumnIndex("COL_DATE"))
                    val mood = it.getBlob(it.getColumnIndex("COL_MOOD"))
                    val content = it.getString(it.getColumnIndex("COL_CONTENT"))
                    val imageUri = it.getBlob(it.getColumnIndex("COL_IMAGE_URI"))

                    dataList.add(DiaryEntry(id, date, mood, content, imageUri))
                } while (it.moveToNext())
            }
        }*/

        cursor.close()
        rd.close()

        return dataList
    }

    // 데이터 업데이트
    fun updateData(diaryEntry: DiaryEntry) {

        val values = ContentValues()
        values.put("id", diaryEntry.id)
        values.put("dDate", diaryEntry.date)
        values.put("dMood", diaryEntry.mood)
        values.put("dContent", diaryEntry.content)
        values.put("dImage", diaryEntry.imageUri)

        val wd = this.writableDatabase
        wd.update("diaryEntry", values, "id = ${diaryEntry.id}", null)
        wd.close()
    }

    // 데이터 삭제
    fun deleteData(diaryEntry: DiaryEntry) {
        val db = this.writableDatabase
        db.execSQL("DELETE FROM diaryEntry where id = ${diaryEntry.id}")
        db.close()
    }
}