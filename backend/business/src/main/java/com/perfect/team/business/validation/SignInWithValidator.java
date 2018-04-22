package com.perfect.team.business.validation;

import com.perfect.team.business.model.AuthMethod;
import com.perfect.team.business.validation.constraint.SignInWith;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.exception.FacebookOAuthException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
@Component
public class SignInWithValidator implements ConstraintValidator<SignInWith, Object[]> {

  @Value("${facebook.api.version}")
  private String facebookApiVersion;

  @Value("${facebook.app.id}")
  private String facebookAppId;

  @Value("${facebook.app.secret}")
  private String facebookAppSecret;

  @Override
  public void initialize(SignInWith constraintAnnotation) {
  }

  @Override
  public boolean isValid(Object[] value, ConstraintValidatorContext context) {
    String accessToken = (String) value[0];
    AuthMethod method = (AuthMethod) value[1];
    switch (method) {
      case FACEBOOK:
        return isValidFacebook(accessToken, context);
      default:
        return true;
    }
  }

  private boolean isValidFacebook(String accessToken, ConstraintValidatorContext context) {
    FacebookClient facebookClient = new DefaultFacebookClient(accessToken, facebookAppSecret,
        Version.valueOf(facebookApiVersion));
    try {
      com.restfb.types.User facebookUser = facebookClient
          .fetchObject("me", com.restfb.types.User.class,
              Parameter.with("fields", "email, name"));
      if (facebookUser.getEmail() == null) {
        context.buildConstraintViolationWithTemplate("Facebook email is null")
            .addConstraintViolation();
        return false;
      }
    } catch (FacebookOAuthException e) {
      return false;
    }
    return true;
  }
}
