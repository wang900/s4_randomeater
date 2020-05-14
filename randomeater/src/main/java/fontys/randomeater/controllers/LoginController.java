package fontys.randomeater.controllers;

import fontys.randomeater.models.Account;
import fontys.randomeater.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController extends ControllerBase<Account> {

    @Autowired
    AccountService accountService;

    @PostMapping("/")
    public ResponseEntity<?> login(@RequestBody Account account) {
        ResponseEntity<?> response = new ResponseEntity<>("Vul alle inloggegevens in", HttpStatus.BAD_REQUEST);
        if(!account.getEmail().trim().equals("") && !account.getPassword().equals("")) {
            response = new ResponseEntity<>("De gegeven inloggegevens zijn incorrect", HttpStatus.BAD_REQUEST);
            Account result = accountService.login(account.getEmail());
            if(result != null) {
                response = new ResponseEntity<>(result, HttpStatus.OK);
            }
        }

        return response;
    }
}
