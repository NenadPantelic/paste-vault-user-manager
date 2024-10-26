package com.pastevault.usermanager.repository;

import com.pastevault.apicommon.exception.ApiException;
import com.pastevault.apicommon.exception.ErrorReport;
import com.pastevault.usermanager.model.User;
import com.pastevault.usermanager.util.ExceptionMessageParser;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    default User findOrNotFound(int userId) {
        return this.findById(userId).orElseThrow(() -> new ApiException(ErrorReport.NOT_FOUND));
    }

    default User doSave(User user) {
        try {
            return this.save(user);
        } catch (DataIntegrityViolationException | ConstraintViolationException e) {
            String errMessage = null;
            if (e instanceof DataIntegrityViolationException) {
                errMessage = ExceptionMessageParser.getDataIntegrityViolationExceptionMessage(
                        (DataIntegrityViolationException) e
                );
            }

            ErrorReport errorReport = ErrorReport.CONFLICT;
            if (errMessage != null) {
                errorReport = errorReport.withErrors(errMessage);
            }

            throw new ApiException(errorReport);
        }
    }
}
