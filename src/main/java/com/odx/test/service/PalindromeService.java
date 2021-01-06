package com.odx.test.service;

import com.odx.test.model.Palindrome;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PalindromeService {

    private final PalindromeRepository palindromeRepository;

    public PalindromeService(PalindromeRepository palindromeRepository) {
        this.palindromeRepository = palindromeRepository;
    }

    public Palindrome StorePalindrome( String  name) {

        Palindrome pal = new Palindrome();
                pal.setName(findPali(name));
       return palindromeRepository.save(pal);


    }

private  String findPali(String palindromeString){

    int maxLength = 1, start = 0;

    for (int index = 0; index < palindromeString.length(); index++) {
        for (int inner = index; inner < palindromeString.length(); inner++) {
            boolean flag = true;

            for (int i = 0; i < (inner - index + 1) / 2; i++)
                if (palindromeString.charAt(index + i) != palindromeString.charAt(inner - i))
                    flag = false;

            if (flag && (inner - index + 1) > maxLength) {
                start = index;
                maxLength = inner - index + 1;
            }
        }
    }
   return palindromeString.substring(start, start + maxLength);
}

    public Optional<Palindrome> findPalindromeById(Integer id) {
        return palindromeRepository.findById(id);
    }
}
