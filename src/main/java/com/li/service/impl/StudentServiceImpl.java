package com.li.service.impl;

import com.li.po.Student;
import com.li.mapper.StudentMapper;
import com.li.service.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nanGua
 * @since 2018-06-26
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
