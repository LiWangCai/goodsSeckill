package com.li.po;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author nanGua
 * @since 2018-06-26
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String studentName;
    private Integer credit;


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Student{" +
        ", studentName=" + studentName +
        ", credit=" + credit +
        "}";
    }
}
