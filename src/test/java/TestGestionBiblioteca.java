import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sebas.lab.testing.GestionBiblioteca;

public class TestGestionBiblioteca {

    private GestionBiblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = new GestionBiblioteca();
        System.out.println("INICIANDO PRUEBA");
    }

    @After
    public void tearDown() {
        biblioteca = null;
    }

    // PREGUNTA1
    @Test
    public void sinDescuento() {
        double precioBase = 2.00;
        double porcentajeDescuento = 0.00;
        double resultado = biblioteca.calcularPrecioConDescuento(precioBase, porcentajeDescuento);

        Assert.assertEquals(precioBase, resultado, 0.001);
    }

    @Test
    public void conCincuenta() {
        double precioBase = 2.00;
        double porcentajeDescuento = 50.00;
        double resultado = biblioteca.calcularPrecioConDescuento(precioBase, porcentajeDescuento);

        Assert.assertEquals(1.00, resultado, 0.001);
    }

    @Test
    public void conCien() {
        double precioBase = 2.00;
        double porcentajeDescuento = 100.00;
        double resultado = biblioteca.calcularPrecioConDescuento(precioBase, porcentajeDescuento);

        Assert.assertEquals(0.00, resultado, 0.001);
    }
    // PREGUNTA2
    @Test
    public void testLibroNoDisponible() {

        String libro = "spiderman";

        Assert.assertFalse(this.biblioteca.estaDisponible(libro));
    }

    @Test
    public void testLibroDisponible() {
        this.biblioteca.agregarLibro("El senior de los anillos");

        Assert.assertTrue(this.biblioteca.estaDisponible("El senior de los anillos"));
    }

    // PREGUNTA3

    @Test
    public void testAgregarLibroNull() {
        String libro = null;
        Assert.assertFalse(this.biblioteca.agregarLibro(libro));
    }

    @Test
    public void testAgregarLibroConEspacios() {
        Assert.assertTrue(this.biblioteca.agregarLibro("  El senior de los anillos  "));
        Assert.assertTrue(this.biblioteca.estaDisponible("El senior de los anillos"));
    }

    // PREGUNTA4
    @Test
    public void testPrincipiante() {
        Assert.assertEquals("Principiante", this.biblioteca.obtenerCategoriaLector(0));
    }

    @Test
    public void testIntermedio() {
        Assert.assertEquals("Intermedio", this.biblioteca.obtenerCategoriaLector(5));
    }

    @Test
    public void testAvanzado() {
        Assert.assertEquals("Avanzado", this.biblioteca.obtenerCategoriaLector(25));
    }

    //Pregunta 5
    @Test
    public void testNoNull() {
        Assert.assertNotNull(this.biblioteca.obtenerLibrosDisponibles());
    }

    @Test
    public void testListaVacia() {
        Assert.assertTrue(this.biblioteca.obtenerLibrosDisponibles().isEmpty());
    }
}