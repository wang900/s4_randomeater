package fontys.randomeater.controllers;

import fontys.randomeater.builder.response.Response;
import fontys.randomeater.models.Account;
import fontys.randomeater.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController extends CRUDController<Account> {

    private AccountService accountService;

    AccountController(AccountService service) {
        super(service);
        this.accountService = service;
    }

    @PostMapping("/customers/register")
    public ResponseEntity<?> register(@RequestBody Account account) {
        ResponseEntity<?> response = new ResponseEntity<>("De gegeven gegevens zijn incorrect", HttpStatus.BAD_REQUEST);
        Account result = accountService.registerNewCustomerAccount(account);
        if(result != null) {
            response = new ResponseEntity<Account>(result, HttpStatus.OK);
        }
        return response;
    }

    @PostMapping("/login")
    public Response<?> login(@RequestBody Account account) {
        Account a = accountService.login(account.getEmail(), account.getPassword());
        if(a == null) {
            return responseDirector.getFailResponse("The given ", HttpStatus.BAD_REQUEST);
        }
        else {
            return responseDirector.getSuccessResponse(1, a, HttpStatus.OK);
        }
    }
}
