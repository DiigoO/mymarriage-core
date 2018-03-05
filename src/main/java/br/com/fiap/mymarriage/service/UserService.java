package br.com.fiap.mymarriage.service;

import br.com.fiap.mymarriage.model.User;
import br.com.fiap.mymarriage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        User users = userRepository.findByNome(user.getNome());
        if(users != null){
            user.setId(users.getId());
        }
        userRepository.save(user);
    }

    public User buscarUser(String user){
        return userRepository.findByNome(user);
    }

    public Boolean login(String user, String password){
        User users = userRepository.findByNomeAndPassword(user, password);
        if(users != null){
            return false;
        }
        return true;
    }
}
