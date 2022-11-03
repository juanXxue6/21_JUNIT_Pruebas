package JUnit.junit09_Geometria_test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import JUnit.Junit09_Geometria.dto.Geometria;

class GeometriaTestTest {

	Geometria geometria;
	
	@BeforeEach
	public void createFigure() {
		geometria = new Geometria();
		System.out.println("Create a circle");
		
	}
	
	
	//area Cuadrado
	@Test
	public void areaCuadradoTest() {
		int result = geometria.areacuadrado(5);
		int expected = 25;
		assertEquals(expected, result);	
	}
	
	//area Ciculo
	@Test
	public void areaCirculo() {
		double result = geometria.areaCirculo(2);
		double expected = 12.5664;
		assertEquals(expected, result);
	}
	
	//areaTraingulo
	@Test
	public void areaTriangulo() {
		int result = geometria.areatriangulo(8,3);
		int expected = 12;
		assertEquals(expected, result);
		
	}
	
	//areaRectangulo
	@Test
	public void areaPentagono() {
		int result = geometria.areapentagono(6,8);
		int expected = 24;
		assertEquals(expected, result);
		
	}
	
	@Test
	public void areaRombo() {
		int result = geometria.arearombo(15,8);
		int expected = 60;
		assertEquals(expected, result);
		
	}
	
	@Test
	public void areaRomboide() {
		int result = geometria.arearomboide(9,7);
		int expected = 63;
		assertEquals(expected, result);
		
	}
	
	@Test
	public void areaTrapecio() {
		int result = geometria.areatrapecio(7,7,3);
		int expected = 21;
		assertEquals(expected, result);
		
	}
	
	
	
	private static Stream<Arguments> getFigures(){		
		return Stream.of(
				Arguments.of(1,"cuadrado"),
				Arguments.of(2,"Circulo"),
				Arguments.of(3,"Triangulo"),
				Arguments.of(4,"Rectangulo"),
				Arguments.of(5,"Pentagono"),
				Arguments.of(6,"Rombo"),
				Arguments.of(7,"Romboide"),
				Arguments.of(8,"Trapecio"),
				Arguments.of(9,"Default")
				);		
	}
	
	
	@ParameterizedTest
	@MethodSource("getFigures")
	public void figuresAreasTest(int code, String expected) {
		String result = geometria.figura(code);
		
		assertEquals(expected, result);
	}
	


	@Test
	public void GettterSetterId() {

		for (int i = 1; i < 10; i++) {
			
			geometria.setId(i);
				int expected = geometria.getId();
				int result = i;
				System.out.println("ID: " + geometria.getId());
					assertEquals(expected, result);
		}

	}
	
	private static Stream<Arguments> figuresName(){		
		return Stream.of(
				Arguments.of("cuadrado"),
				Arguments.of("Circulo"),
				Arguments.of("Triangulo"),
				Arguments.of("Rectangulo"),
				Arguments.of("Pentagono"),
				Arguments.of("Rombo"),
				Arguments.of("Romboide"),
				Arguments.of("Trapecio")
				);		
	}
	
	
	@ParameterizedTest
	@MethodSource("figuresName")
	public void GettterSetterNomb(String name) {
		geometria.setNom(name);
		String expected = geometria.getNom();
		System.out.println("Name: " + geometria.getNom());
		assertEquals(expected, name);
		

	}
	
	
	/*
	@AfterEach
	public void resetFigure() {
		System.out.println("reset figure");
	}
*/
}
