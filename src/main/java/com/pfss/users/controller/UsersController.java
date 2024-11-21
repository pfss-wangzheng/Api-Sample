package com.pfss.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfss.users.bean.User;
import com.pfss.users.bean.UserResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;


@RestController
@CrossOrigin
public class UsersController{

    private static final Logger log = LoggerFactory.getLogger(UsersController.class);

    private final ObjectMapper objectMapper = null;

    private final HttpServletRequest request = null;

    @Operation(summary = "Create a new lnb user", description = "Create a new lnb user into LNB system", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "The user was successfully created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))),
        @ApiResponse(responseCode = "400", description = "Bad request (e.g., invalid input)"),
        @ApiResponse(responseCode = "500", description = "Internal server error") })
    @PostMapping(value = "/users/create", produces = { "application/json" }, consumes = { "application/json", "application/xml", "application/x-www-form-urlencoded" })
    public ResponseEntity<UserResponse> createUser(@Parameter(in = ParameterIn.DEFAULT, description = "Created user object", schema=@Schema()) @Valid @RequestBody User body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserResponse>(objectMapper.readValue("{\r\n  \"message\" : \"User created successfully\",\r\n  \"user\" : {\r\n    \"name\" : \"Smith\",\r\n    \"id\" : 1,\r\n    \"email\" : \"Smith@panasonic.com\"\r\n  },\r\n  \"status\" : \"success\"\r\n}", UserResponse.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserResponse>(HttpStatus.NOT_IMPLEMENTED);
    }
    
    @Operation(summary = "Delete existing lnb user", description = "Delete existing lnb user from system by id", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Invalid user name") })
    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<Void> deleteUser(@Parameter(in = ParameterIn.PATH, description = "ID of user", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Get all lnb users", description = "Get all lnb users infomation", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "get user success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))) })
    @GetMapping(value = "/users",produces = { "application/json" })
    public ResponseEntity<User> getAllUsersInfo() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\r\n  \"name\" : \"Smith\",\r\n  \"id\" : 1,\r\n  \"email\" : \"Smith@panasonic.com\"\r\n}", User.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<User>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Operation(summary = "Upate existing lnb user", description = "Upate existing lnb user into LNB system", tags={ "User" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))), 
        @ApiResponse(responseCode = "400", description = "Invalid userinfo"),
        @ApiResponse(responseCode = "404", description = "User not found") })
    @PutMapping(value = "/users/update", produces = { "application/json", "application/xml" }, consumes = { "application/json" })
    public ResponseEntity<User> updateUser(@Parameter(in = ParameterIn.DEFAULT, description = "Update user object", schema=@Schema()) @Valid @RequestBody User body) {
            try {
                return new ResponseEntity<User>(objectMapper.readValue("{\r\n  \"name\" : \"Smith\",\r\n  \"id\" : 1,\r\n  \"email\" : \"Smith@panasonic.com\"\r\n}", User.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }

}
