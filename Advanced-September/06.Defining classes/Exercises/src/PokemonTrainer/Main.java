package PokemonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        Trainer trainer;
        Pokemon pokemon;
        while (!input.equals("Tournament")) {
            String[] tokens = input.split("\\s+");
            String trainers = tokens[0];
            String pokemons = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            pokemon = new Pokemon(pokemons, element, health);
            trainerMap.putIfAbsent(trainers, new Trainer());
            trainerMap.get(trainers).addPokemon(pokemon);
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            for (Map.Entry<String, Trainer> trainerEntry : trainerMap.entrySet()) {
                if (trainerEntry.getValue().pokemonCollectionSize() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon pokemon1 : trainerEntry.getValue().getPokemons()) {
                        if (pokemon1.getElement().equals(command)) {
                            havePokemon = true;
                            trainerEntry.getValue().setNumberOfBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        trainerEntry.getValue().killedPokemon();

                    }
                }
            }
            command = scanner.nextLine();
        }
        trainerMap.entrySet().stream().sorted((p1, p2) -> Integer.compare(p2.getValue()
                .getNumberOfBadges(), p1.getValue().getNumberOfBadges())).forEach(v -> {
            System.out.printf("%s %s %s%n", v.getKey(), v.getValue().getNumberOfBadges(), v.getValue().pokemonCollectionSize());
        });
    }
}