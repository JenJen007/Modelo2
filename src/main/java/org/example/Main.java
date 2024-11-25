package org.example;

import org.example.entidades.*;
import org.example.repositorios.ArticuloRepository;
import org.example.repositorios.PromocionRepository;
import org.example.repositorios.impl.InMemoryArticuloRepository;
import org.example.repositorios.impl.InMemoryPromocionRepository;

import java.time.LocalDate;
import java.time.LocalTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear repositorios usando implementaciones en memoria
        ArticuloRepository articuloRepo = new InMemoryArticuloRepository();
        PromocionRepository promocionRepo = new InMemoryPromocionRepository();

        // Crear datos de ejemplo
        UnidadMedida ochoPorciones = new UnidadMedida(1L, "8 Porciones");
        Imagen imagen1 = new Imagen(1L, "Pizza grande Hawaiana");

        Articulo pizzaHawaiana = new Articulo(1L, "Pizza grande Hawaiana", 500.0, 300.0, 10, 20, ochoPorciones, imagen1);

        articuloRepo.add(pizzaHawaiana);

        Promocion happyHour = Promocion.builder()
                .id(1L)
                .denominacion("Happy Hour")
                .fechaDesde(LocalDate.now())
                .fechaHasta(LocalDate.now().plusDays(7))
                .horaDesde(LocalTime.of(18, 0))
                .horaHasta(LocalTime.of(20, 0))
                .descripcionDescuento("Descuento en bebidas y comidas")
                .precioPromocional(800.0d)
                .tipoPromocion(TipoPromocion.HAPPY_HOUR)
                .build();

        happyHour.getArticulos().add(pizzaHawaiana);

        promocionRepo.add(happyHour);

        // Mostrar datos
        System.out.println("Promociones disponibles:");
        promocionRepo.findAll().forEach(System.out::println);

        System.out.println("Artículos disponibles:");
        articuloRepo.findAll().forEach(System.out::println);
    }
}