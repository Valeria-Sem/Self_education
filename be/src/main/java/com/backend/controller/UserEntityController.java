package com.backend.controller;

//import com.backend.dto.AuthenticationRequestDto;
//import com.backend.security.jwt.JwtTokenProvider;
import com.backend.entity.UserEntity;
import com.backend.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/")
public class UserEntityController {

    private final UserEntityService userEntityService;
//    private final AuthenticationManager authenticationManager;
//    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserEntityController(UserEntityService userEntityService
//                                AuthenticationManager authenticationManager,
//                                JwtTokenProvider jwtTokenProvider
                                ) {
        this.userEntityService = userEntityService;
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenProvider = jwtTokenProvider;
    }

//    @PostMapping("login")
//    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto){
//        try{
//            String login = requestDto.getLogin();
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, requestDto.getPassword()));
//            UserEntity userEntity = userEntityService.findByLogin(login);
//
//            if(userEntity == null){
//                throw new UsernameNotFoundException("User with login: " + login + "not found");
//            }
//
////            List<UserRole> roles = Arrays.asList(userEntity.getRole());
//
//            String token = jwtTokenProvider.createToken(login, userEntity.getRole());
//
//            Map<Object, Object> response = new HashMap<>();
//            response.put("login", login);
//            response.put("token", token);
//
//            return ResponseEntity.ok(response);
//
//        }catch (AuthenticationException e){
//            throw new BadCredentialsException("Invalid login or password");
//        }
//    }

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUsersByLogin(@PathVariable(name = "login") String login) {
        UserEntity userEntity = userEntityService.findByLogin(login);
        return ResponseEntity.ok(userEntity);
    }
//    @RequestMapping(value = "/login/{login}/{pass}", method = RequestMethod.GET)
//    public ResponseEntity<UserEntity> getUsersByLoginP(@PathVariable(name = "login") String login,
//                                                       @PathVariable(name = "pass") String pass) {
//        UserEntity userEntity = userEntityService.getUserIdByLoginAndPassword(login, pass);
//        return ResponseEntity.ok(userEntity);
//    }

    @RequestMapping(value = "/delete/{idUser}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "idUser") Integer idUser) {
        userEntityService.delete(idUser);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<UserEntity> getAllUsers(){
        return userEntityService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity saveUser(@RequestBody UserEntity userEntity){
        return userEntityService.save(userEntity);
    }
}
