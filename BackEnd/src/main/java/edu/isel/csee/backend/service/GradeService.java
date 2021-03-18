package edu.isel.csee.backend.service;

import edu.isel.csee.backend.controller.RestException;
import edu.isel.csee.backend.form.document.Grade;
import edu.isel.csee.backend.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) { this.gradeRepository = gradeRepository; }

    @Transactional
    public Grade saveGrade(Grade grade) {

        validateDuplicateGradeAndDelete(grade);

        return gradeRepository.save(grade);
    }

    @Transactional
    public Long deleteGrade(String studentNum, String token)
    {
        validateExistenceGrade(studentNum, token);

        Optional<Grade> gradeEntityWrapper = gradeRepository.findByStudentNumAndToken(studentNum, token);
        Grade gradeEntity = gradeEntityWrapper.get();

        return gradeRepository.deleteById(gradeEntity.getId());
    }

    @Transactional
    public Grade getGrade(String studentNum, String token)
    {
        validateExistenceGrade(studentNum, token);

        Optional<Grade> gradeEntityWrapper = gradeRepository.findByStudentNumAndToken(studentNum, token);
        Grade gradeEntity = gradeEntityWrapper.get();

        Grade grade = new Grade
                (
                        gradeEntity.getId(),
                        gradeEntity.getStudentNum(),
                        gradeEntity.getToken(),
                        gradeEntity.getClassName(),
                        gradeEntity.getInstructor(),
                        gradeEntity.getGradingDate(),
                        gradeEntity.getPoint(),
                        gradeEntity.getCompile(),
                        gradeEntity.getRuntimeResult(),
                        gradeEntity.getPackages(),
                        gradeEntity.getClasses(),
                        gradeEntity.getCustomException(),
                        gradeEntity.getCustomStructure(),
                        gradeEntity.getOverriding(),
                        gradeEntity.getOverloading(),
                        gradeEntity.getThread(),
                        gradeEntity.getJavadoc(),
                        gradeEntity.getEncapsulation(),
                        gradeEntity.getInheritSuper(),
                        gradeEntity.getInheritInterface(),
                        gradeEntity.getResult()
                );

        return grade;
    }

    private void validateDuplicateGrade(Grade grade) {
        gradeRepository.findByStudentNumAndToken(grade.getStudentNum(), grade.getToken())
                .ifPresent(m -> {
                    throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, grade.getToken() + "(" + grade.getStudentNum() + ")" + " already exist!");
                });
    }

    private void validateDuplicateGradeAndDelete(Grade grade) {
        gradeRepository.findByStudentNumAndToken(grade.getStudentNum(), grade.getToken())
                .ifPresent(m -> {
                    deleteGrade(grade.getStudentNum(), grade.getToken());
                });
    }

    private void validateExistenceGrade(String studentNum, String name) {
        if(gradeRepository.findByStudentNumAndToken(studentNum, name).isEmpty())
            throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "No existence in DB - " + name + "(" + studentNum + ")");
    }
}
