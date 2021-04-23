package com.example.myasistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {

    private static final String NOMBRE_DB = "asistencia.db";
    private  static final int VERSION_DB = 3;
    private static  final String TABLE_CURSOS = "CREATE TABLE cursos (id INTEGER,nombre TEXT,PRIMARY KEY(id AUTOINCREMENT));";
    private static  final String TABLE_CURSO_PARALELO = "CREATE TABLE curso_paralelo (id INTEGER,id_curso INTEGER,id_paralelo INTEGER,PRIMARY KEY(id),FOREIGN KEY(id_curso) REFERENCES cursos(id) on delete cascade,FOREIGN KEY(id_paralelo) REFERENCES paralelos(id) on delete cascade)";
    private static  final String TABLE_ESTUDIANTES = "CREATE TABLE estudiantes (id INTEGER,nombre TEXT,apellido TEXT,id_curso_paralelo INTEGER,PRIMARY KEY(id AUTOINCREMENT),FOREIGN KEY(id_curso_paralelo) REFERENCES curso_paralelo(id) on delete cascade)";
    private static  final String TABLE_MATERIAS = "CREATE TABLE materias (id INTEGER,nombre TEXT,PRIMARY KEY(id AUTOINCREMENT))";
    private static  final String TABLE_MAESTROS = "CREATE TABLE maestros (id INTEGER,nombre TEXT,apellido TEXT,PRIMARY KEY(id))";
    private static  final String TABLE_MATERIA_MAESTRO = "CREATE TABLE  materia_maestro (id INTEGER,id_materia INTEGER,id_maestro INTEGER,PRIMARY KEY(id AUTOINCREMENT),FOREIGN KEY(id_maestro) REFERENCES maestros(id) on delete cascade,FOREIGN KEY(id_materia) REFERENCES materias(id) on delete cascade)";
    private static  final String TABLE_ASISTENCIAS = "CREATE TABLE  asistencias (id INTEGER,fecha TEXT,hora TEXT,id_estudiante INTEGER,id_materia_maestro INTEGER,PRIMARY KEY(id AUTOINCREMENT),FOREIGN KEY(id_materia_maestro) REFERENCES materia_maestro(id) on delete cascade,FOREIGN KEY(id_estudiante) REFERENCES estudiantes(id) on delete cascade)";
    private static  final String TABLE_PARALELO = "CREATE TABLE paralelos (id INTEGER,nombre NUMERIC,PRIMARY KEY(id) )";

    public static final String insert_a = "INSERT INTO cursos VALUES (1,'A'), (2,'B'), (3,'C'), (4,'D')";
    public static final String insert_b = "INSERT INTO curso_paralelo VALUES (1,3,1), (2,2,4), (3,4,2)";
    public static final String insert_c = "INSERT INTO estudiantes VALUES (1,'Daniel','Lara',2), (2,'Andres','Ramirez',1), (3,'Eduardo','Jimenez',3)";
    public static final String insert_d = "INSERT INTO materias VALUES (1,'Lenguaje'), (2,'Matematica'), (3,'ingles')";
    public static final String insert_f = "INSERT INTO maestros VALUES (1,'Telmo','Ramirez'), (2,'Caros','Lara'), (3,'Xavier','Quinto')";
    public static final String insert_g = "INSERT INTO materia_maestro VALUES (1,2,1), (2,3,2), (3,1,3)";
    public static final String insert_h = "INSERT INTO asistencias VALUES (1,'2019-03-17','09:30:27',2,3), (2,'2020-08-15','10:30:56',1,2), (3,'2021-02-14','13:30:45',3,1)";
    public static final String insert_i = "INSERT INTO paralelos VALUES (1,1), (2,2), (3,3), (4,4), (5,5), (6,6), (7,7)";





    public DB(Context context){
        super(context, NOMBRE_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CURSOS);
        db.execSQL(TABLE_CURSO_PARALELO);
        db.execSQL(TABLE_ESTUDIANTES);
        db.execSQL(TABLE_MATERIAS);
        db.execSQL(TABLE_MAESTROS);
        db.execSQL(TABLE_MATERIA_MAESTRO);
        db.execSQL(TABLE_ASISTENCIAS);
        db.execSQL(TABLE_PARALELO);

        db.execSQL(insert_a);
        db.execSQL(insert_b);
        db.execSQL(insert_c);
        db.execSQL(insert_d);
        db.execSQL(insert_f);
        db.execSQL(insert_g);
        db.execSQL(insert_h);
        db.execSQL(insert_i);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURSOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CURSO_PARALELO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ESTUDIANTES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATERIAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MAESTROS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATERIA_MAESTRO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASISTENCIAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PARALELO);
        db.execSQL(TABLE_CURSOS);
        db.execSQL(TABLE_CURSO_PARALELO);
        db.execSQL(TABLE_ESTUDIANTES);
        db.execSQL(TABLE_MATERIAS);
        db.execSQL(TABLE_MAESTROS);
        db.execSQL(TABLE_MATERIA_MAESTRO);
        db.execSQL(TABLE_ASISTENCIAS);
        db.execSQL(TABLE_PARALELO);
    }


    public ArrayList getAllCours(){
        ArrayList arrayCursos = new ArrayList();

        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "SELECT curso_paralelo.id, cursos.nombre||'/'||paralelos.nombre as nombre FROM curso_paralelo JOIN cursos ON cursos.id = curso_paralelo.id_curso JOIN paralelos ON paralelos.id = curso_paralelo.id_paralelo";

        db.execSQL(sql);

        System.out.print("hola");

        return arrayCursos;
    }

    public ArrayList getAllStudents(String id_cours){
        ArrayList arrayEstudiantes = new ArrayList();


        String sql = "SELECT * FROM estudiantes WHERE id_curso_paralelo = "+ id_cours;
        return arrayEstudiantes;
    }
}
