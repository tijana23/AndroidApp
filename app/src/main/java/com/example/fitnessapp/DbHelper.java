package com.example.fitnessapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";
    public DbHelper(Context context) {
        super(context, "Databaza12345678.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)");
        MyDB.execSQL("create Table workouts(wID INTEGER primary key,grupa VARCHAR(10),target VARCHAR(10),nameWorkout VARCHAR(10),time VARCHAR(25),level VARCHAR(100),instructions VARCHAR(1500),image VARCHAR(100)) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists workouts");

    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public String WorkoutName(String name) {
        SQLiteDatabase read = this.getReadableDatabase();
        Cursor cursor = read.rawQuery("SELECT nameWorkout FROM workouts WHERE grupa=?", new String[]{name});
        cursor.moveToFirst();
        String result=cursor.getString(0);
        while(cursor.moveToNext()){
            result+=","+ cursor.getString(0);
        }
        cursor.close();
        return result;
    }
    public String Instructions(String name) {
        SQLiteDatabase read = this.getReadableDatabase();
        Cursor cursor = read.rawQuery("SELECT instructions FROM workouts WHERE grupa=?", new String[]{name});
        cursor.moveToFirst();
        String result=cursor.getString(0);
        while(cursor.moveToNext()){
            result+="/"+ cursor.getString(0);
        }
        cursor.close();
        return result;
    }
    public String Level(String name) {
        SQLiteDatabase read = this.getReadableDatabase();
        Cursor cursor = read.rawQuery("SELECT level FROM workouts WHERE grupa=?", new String[]{name});
        cursor.moveToFirst();
        String result=cursor.getString(0);
        while(cursor.moveToNext()){
            result+=","+ cursor.getString(0);
        }
        cursor.close();
        return result;
    }
    public String Target(String name) {
        SQLiteDatabase read = this.getReadableDatabase();
        Cursor cursor = read.rawQuery("SELECT target FROM workouts WHERE grupa=?", new String[]{name});
        cursor.moveToFirst();
        String result=cursor.getString(0);
        while(cursor.moveToNext()){
            result+=","+ cursor.getString(0);
        }
        cursor.close();
        return result;
    }
    public String Time(String name) {
        SQLiteDatabase read = this.getReadableDatabase();
        Cursor cursor = read.rawQuery("SELECT time FROM workouts WHERE grupa=?", new String[]{name});
        cursor.moveToFirst();
        String result=cursor.getString(0);
        while(cursor.moveToNext()){
            result+=","+ cursor.getString(0);
        }
        cursor.close();
        return result;
    }
    public String Image(String name) {
        SQLiteDatabase read = this.getReadableDatabase();
        Cursor cursor = read.rawQuery("SELECT image FROM workouts WHERE grupa=?", new String[]{name});
        cursor.moveToFirst();
        String result=cursor.getString(0);
        while(cursor.moveToNext()){
            result+=","+ cursor.getString(0);
        }
        cursor.close();
        return result;
    }

    public void popolni() {
        SQLiteDatabase read = this.getReadableDatabase();
        String query = "SELECT * FROM workouts";
        Cursor c = read.rawQuery(query, null);
        if (!(c.getCount() > 0)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Side Plank");
            cv.put("level", "Beginner");
            cv.put("time", "1 minute");
            cv.put("target", "external oblique");
            cv.put("instructions", "1. Lie on your side with your body fully extended.\n2. Lift your body off the ground and balance your weight between the forearm and the side of the foot.\n3. Keep your body in a straight line and hold for as long as you can.\n4. Change sides and repeat.");
            cv.put("image","side_plank");
            db.insert("workouts", null, cv);

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Side Plank Hip Abduction");
            cv.put("level", "Intermediate");
            cv.put("time", "1 minute");
            cv.put("target", "external oblique");
            cv.put("instructions", "1. Start in a modified side plank position, with your top leg extended and your bottom leg bent back with the knee on the mat.\n2. Lift your top leg as high as possible and then lower it back down.\n3. Repeat and then switch sides.");
            cv.put("image","side_plank_hip_abduction");
            db.insert("workouts", null, cv);


            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","T-Rotation");
            cv.put("level", "Intermediate");
            cv.put("time", "1 minute");
            cv.put("target", "external oblique");
            cv.put("instructions", "1. Start in a side plank position, with your right shoulder over your elbow, your body in a straight line, and reach your left hand toward the ceiling.\n2. Twist your torso forward and slowly place your left arm under your body.\n3. Repeat and then switch sides.");
            cv.put("image","t_rotation");
            db.insert("workouts", null, cv);

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Abdominal Bridge");
            cv.put("level", "Advanced");
            cv.put("time", "1 minute");
            cv.put("target", "external oblique");
            cv.put("instructions", "1. Lie on your stomach with your legs fully extended and your forearms on the mat.\n2. Engage your core and lift your hips.\n3. Pause for 2 seconds, then return to the starting position.\n4. Repeat until the set is complete.");
            cv.put("image","abdominal_bridge");
            db.insert("workouts", null, cv);

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Boat Twist");
            cv.put("level", "Beginner");
            cv.put("time", "1 minute");
            cv.put("target", "internal oblique");
            cv.put("instructions", "1. Sit down on a mat with your knees bent, extend your arms out to the sides and lift your feet off the floor.\n" +
                    "2. Twist your torso to the right, and then reverse the motion, twisting it to the left.\n" +
                    "3. Repeat this movement until the set is complete.");
            cv.put("image","boat_twist");
            db.insert("workouts", null, cv);

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Band Leg Abduction Crunch");
            cv.put("level", "Beginner");
            cv.put("time", "1 minute");
            cv.put("target", "internal oblique");
            cv.put("instructions", "1. Lie on the mat, place a resistance band around both legs and raise the legs toward the ceiling.\n" +
                    "2. Lift your shoulders, open the legs and chop your hands through your legs.\n" +
                    "3. Lower your torso, close the legs and return to the starting position.\n" +
                    "4. Repeat until the set is complete.");
            cv.put("image","band_leg_abduction_crunch");
            db.insert("workouts", null, cv);

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Basketball Shots");
            cv.put("level", "Intermediate");
            cv.put("time", "45 seconds");
            cv.put("target", "internal oblique");
            cv.put("instructions", "1. Stand with your feet shoulder-width apart and the toes pointing slightly outward.\n2. Bend your knees, press your hips back, and take both hands close to your right foot.\n3. Jump up and extend your arms above your head and to the left.\n4. Land with your knees slightly bent and go back into the squat position.\n5. Repeat and then switch sides.");
            cv.put("image","basketball_shots");
            db.insert("workouts", null, cv);

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Bicycle Crunches");
            cv.put("level", "Advanced");
            cv.put("time", "30 seconds");
            cv.put("target", "internal oblique");
            cv.put("instructions", "1. Lie on your back, lift your shoulders off the mat and raise both legs.\n2. Bring one knee and the opposing elbow close to each other by crunching to one side, and fully extend the other leg.\n3. Return to the starting position and then crunch to the opposite side.\n4. Repeat until the set is complete.");
            cv.put("image","bicycle_crunches");
            db.insert("workouts", null, cv);

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Band Reverse Plank");
            cv.put("level", "Advanced");
            cv.put("time", "1 minute");
            cv.put("target", "transverse abdominis");
            cv.put("instructions", "1. Sit on the mat with your legs extended, place a band around your waist, extend your arms back with your fingers facing the body, and secure the band under your hands.\n2. Lift your butt off the mat and squeeze the glutes.\n3. Lower the hips to return to the starting position and repeat.");
            cv.put("image","band_reverse_plank");
            db.insert("workouts", null, cv);

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Bent Leg Jackknife");
            cv.put("level", "Beginner");
            cv.put("time", "1 minute");
            cv.put("target", "transverse abdominis");
            cv.put("instructions", "1. Lie on your back with your legs straight and your arms extended back.\n2. Raise your torso and bend your knees simultaneously, and then hug your knees with both hands.\n3. Return to the starting position and repeat.");
            cv.put("image","bent_leg_jackknife");
            db.insert("workouts", null, cv);

            cv.put("grupa", "Abs workouts");
            cv.put("nameWorkout","Balance Chop");
            cv.put("level", "Beginner");
            cv.put("time", "1 minute");
            cv.put("target", "transverse abdominis");
            cv.put("instructions", "1. Stand straight with your feet wide and hold a dumbbell with both hands.\n2. Rotate your torso to the left and raise the dumbbell above your head.\n3. Lift your right knee as you rotate your torso to the right, and bring the dumbbell diagonally across the body until it’s close to your right hip.\n4. Repeat and then switch sides.");
            cv.put("image","balance_chop");
            db.insert("workouts", null, cv);



            c.close();
        }
    }

    public int count() {
        SQLiteDatabase read = this.getReadableDatabase();
        String query = "SELECT wID FROM workouts";
        Cursor c = read.rawQuery(query, null);
        return c.getCount();
    }
}