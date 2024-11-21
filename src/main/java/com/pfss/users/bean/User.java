package com.pfss.users.bean;

import io.swagger.v3.oas.annotations.media.Schema;

public class User   {

  private Long id = null;

  private String name = null;

  private String email = null;


  public User id(Long id) { 

    this.id = id;
    return this;
  }

  
  @Schema(example = "1", description = "User ID")
  
  public Long getId() {  
    return id;
  }

  public void setId(Long id) { 
    this.id = id;
  }

  public User name(String name) { 
    this.name = name;
    return this;
  }

  
  @Schema(example = "Smith", description = "User Name")
  public String getName() {  
    return name;
  }

  public void setName(String name) { 
    this.name = name;
  }

  public User email(String email) { 

    this.email = email;
    return this;
  }

  @Schema(example = "Smith@panasonic.com", description = "User Email")
  public String getEmail() {  
    return email;
  }

  public void setEmail(String email) { 
    this.email = email;
  }


}
