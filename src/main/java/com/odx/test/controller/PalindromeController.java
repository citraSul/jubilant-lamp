package com.odx.test.controller;

import com.odx.test.model.Palindrome;
import com.odx.test.service.PalindromeService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PalindromeController {

    private final PalindromeService palindromeService;

    public PalindromeController(PalindromeService palindromeService) {
        this.palindromeService = palindromeService;
    }

    @GetMapping(value = "/palindrome/{id}", produces = APPLICATION_JSON_VALUE)
    public Palindrome retrievesPalindrome(@PathVariable Integer id) {
        Optional<Palindrome> palindromeById = palindromeService.findPalindromeById(id);

        return palindromeById.orElse(null);

    }

    @GetMapping(value = "/palindrome/find/{name}", produces = APPLICATION_JSON_VALUE)
    public Palindrome storeLongestPalindrome(@PathVariable String name) {

        Palindrome palindrome = palindromeService.StorePalindrome(name);
        System.out.println("------------------"+palindrome.getName());
        return palindrome;
    }
}
