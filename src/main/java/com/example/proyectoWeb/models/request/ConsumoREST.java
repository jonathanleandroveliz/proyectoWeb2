package com.example.proyectoWeb.models.request;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONObject;
import org.springframework.ui.Model;

import com.example.proyectoWeb.helpers.ViewRouteHelper;



@RestController
public class ConsumoREST {

    private final String URL_PAISES = "https://restcountries.com/v2/all";
    
    @GetMapping("/traerPaises")
    private List<Object> traerPaises() {
        RestTemplate restTemplate = new RestTemplate();
        Object[] paises = restTemplate.getForObject(URL_PAISES, Object[].class);

        System.out.println(paises[0]);

        return Arrays.asList(paises);
    }

    @GetMapping("/paisesAleatorios")
    private ModelAndView paisesAleatorios() {
        RestTemplate restTemplate = new RestTemplate();
        Object[] paises = restTemplate.getForObject(URL_PAISES, Object[].class);

        // Obtener 15 países aleatorios
        List<Object> paisesAleatorios = obtener15PaisesAleatorios(paises);

        // Crear el objeto ModelAndView y establecer la vista
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.paises);
       for (Object objeto : paisesAleatorios) {
        	System.out.println(objeto.toString());
        }
       
        modelAndView.addObject("paises", paisesAleatorios);

        return modelAndView;
    }

    private List<Object> obtener15PaisesAleatorios(Object[] paises) {
        // Obtener 15 índices aleatorios
        List<Integer> indicesAleatorios = obtener15IndicesAleatorios(paises.length);

        // Crear la lista de 15 países aleatorios
        List<Object> paisesAleatorios = new ArrayList<>();
        for (int indice : indicesAleatorios) {
            paisesAleatorios.add(paises[indice]);
        }

        return paisesAleatorios;
    }

    private List<Integer> obtener15IndicesAleatorios(int maximo) {
        List<Integer> indicesAleatorios = new ArrayList<>();
        Random random = new Random();

        while (indicesAleatorios.size() < 15) {
            int indiceAleatorio = random.nextInt(maximo);
            if (!indicesAleatorios.contains(indiceAleatorio)) {
                indicesAleatorios.add(indiceAleatorio);
            }
        }

        return indicesAleatorios;
    }
}
