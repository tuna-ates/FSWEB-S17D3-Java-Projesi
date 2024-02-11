package com.workintech.zoo.exceptions;

import com.workintech.zoo.entity.Kangroo;
import com.workintech.zoo.entity.Koala;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooValidate {

    private static   final String  IS_ID_NOT_VALID="Id can not less than 0";
    private static final String STUDENT_NOT_EXIST = "Student with given id is not exist: ";
    private static final String STUDENT_CREDENTIALS_NOT_VALID = "Student Credentials are not valid";
    public static void isIdNotValid(long id){
        if (id<0){
            throw new ZooException(IS_ID_NOT_VALID, HttpStatus.BAD_REQUEST);
        }
    }

    public static  void isKangrooNotExist(Map<Long, Kangroo> kangrooMap,long id){
        if (!kangrooMap.containsKey(id)){
            throw new ZooException(STUDENT_NOT_EXIST,HttpStatus.NOT_FOUND);
        }
    }

    public static void isKangrooIdentityNotValid(Kangroo kangroo){
        if (kangroo==null||kangroo.getId()==0||kangroo.getName()==null||
                kangroo.getWeight()==0||kangroo.getHeight()==0||
                kangroo.getGender()==null){
            throw new ZooException(STUDENT_CREDENTIALS_NOT_VALID,HttpStatus.BAD_REQUEST);

        }
    }

    public static  void isKoalaNotExist(Map<Long, Koala> koalaMapMap, long id){
        if (!koalaMapMap.containsKey(id)){
            throw new ZooException(STUDENT_NOT_EXIST,HttpStatus.NOT_FOUND);
        }
    }

    public static void isKoalaIdentityNotValid(Koala koala){
        if (koala==null||koala.getId()==0||koala.getName()==null||
                koala.getWeight()==0||koala.getSleepHour()==0||
                koala.getGender()==null){
            throw new ZooException(STUDENT_CREDENTIALS_NOT_VALID,HttpStatus.BAD_REQUEST);

        }
    }
}
