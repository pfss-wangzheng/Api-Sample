package com.pfss.users.bean;

import io.swagger.v3.oas.annotations.media.Schema;


public class UserResponse   {

  private String status = null;

  private String message = null;

  private User user = null;


  public UserResponse status(String status) { 

    this.status = status;
    return this;
  }

  @Schema(example = "success", description = "The status of the user creation request")
  
  public String getStatus() {  
    return status;
  }

  public void setStatus(String status) { 
    this.status = status;
  }

  public UserResponse message(String message) { 

    this.message = message;
    return this;
  }

  @Schema(example = "User created successfully", description = "create status message")
  
  public String getMessage() {  
    return message;
  }

  public void setMessage(String message) { 
    this.message = message;
  }

  public UserResponse user(User user) { 

    this.user = user;
    return this;
  }
  
  @Schema(description = "")
  public User getUser() {  
    return user;
  }


  public void setUser(User user) { 
    this.user = user;
  }


 
}
