package com.marvel.Controlers;

import com.marvel.model.dto.CharacterDTO;
import com.marvel.model.entity.Character;
import com.marvel.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/v1/public/characters")
public class GetControllerCharacter {
    @Autowired
    CharacterRepository characterRepository;

    @GetMapping
    public List<CharacterDTO> getCharacters() {

        List<Character> characters = characterRepository.findAll();
        return characters.stream().map(character -> new CharacterDTO(character.getName(),character.getDescription(),
                character.getBorn(),character.getThumbnail())).collect(Collectors.toList());

    }
    @GetMapping(value = "/{characterId}")
    public CharacterDTO getCharacter(@PathVariable("characterId") Integer id){

        Optional <Character> character = characterRepository.findById(id);
        return character.map(character1 -> new CharacterDTO(character1.getName(), character1.getDescription(),character1.getBorn(), character1.getThumbnail())).get();

    }
    @GetMapping(value = "/character/{name}")
    public CharacterDTO getCharacterBy(@PathVariable("name") String name){
        Character character = characterRepository.findByName(name);
        return new CharacterDTO(character.getName(), character.getDescription(), character.getBorn(), character.getThumbnail());
    }
}
