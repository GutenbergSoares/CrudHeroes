package com.digital.heroisapi.controler;

import com.digital.heroisapi.document.Heroes;
import com.digital.heroisapi.repository.HeroesRepository;
import com.digital.heroisapi.service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digital.heroisapi.constans.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j

public class HeroesContoller {

    HeroesService heroesService;
    HeroesRepository heroesRepository;

    private static final org.slf4j.Logger log=
            org.slf4j.LoggerFactory.getLogger(HeroesContoller.class);

    public HeroesContoller (HeroesService heroesService, HeroesRepository heroesRepository){
        this.heroesService = heroesService;
        this.heroesRepository = heroesRepository;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Heroes> getAllItems (){
       log.info("Solicitando a lista de heróis");
       return heroesService.findAll();
    }


    @GetMapping(HEROES_ENDPOINT_LOCAL+"/{id}")
    public Mono <ResponseEntity<Heroes>> findByIdHero(@PathVariable String id){
        log.info("Solicitando o herói com id {}", id);
        return heroesService.findByIdHero(id)
                .map((item)-> new ResponseEntity<>(item,HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code=HttpStatus.CREATED)
    public Mono<Heroes> creatHero(@RequestBody Heroes heroes){
        log.info("Um novo herói foi criado");
        return heroesService.save(heroes);

    }
    @DeleteMapping(HEROES_ENDPOINT_LOCAL+"/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono <HttpStatus> deletebyIDHero(@PathVariable String id){
        heroesService.deleteByIDHero(id);
        log.info("Deletando um herói com id {}", id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }

}
