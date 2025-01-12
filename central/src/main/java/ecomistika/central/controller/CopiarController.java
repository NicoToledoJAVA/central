/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecomistika.central.controller;

import ecomistika.central.model.Category;
import ecomistika.central.model.Company;
import ecomistika.central.model.Customer;
import ecomistika.central.model.Owner;
import ecomistika.central.model.PaymentMethod;
import ecomistika.central.model.Product;
import ecomistika.central.model.Stock;
import ecomistika.central.service.ICategoryService;
import ecomistika.central.service.ICompanyService;
import ecomistika.central.service.ICustomerService;
import ecomistika.central.service.IOwnerService;
import ecomistika.central.service.IPaymentMethodService;
import ecomistika.central.service.IProductService;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/copiar")
public class CopiarController {

    @Autowired
    private IProductService productServ;

    @Autowired
    private ICategoryService categoryServ;

    @Autowired
    private ICompanyService companyServ;

    @Autowired
    private ICustomerService customerServ;

    @Autowired
    private IOwnerService ownerServ;
    
     @Autowired
    private IPaymentMethodService paymentServ;

    private String rutaAroniumBD = System.getProperty("user.home") + File.separator + "AppData" + File.separator + "Local" + File.separator + "Aronium" + File.separator + "Data" + File.separator + "pos.db";

    @PostMapping("/copyAllCategories")
    public List<Category> obtenerCategoriasAronium() {

        List<Category> productos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + rutaAroniumBD); Statement statement = connection.createStatement()) {

            // Consulta SQL para obtener los datos de las columnas necesarias
            String queryCategory = "SELECT Name FROM ProductGroup";  // Asumiendo que "ProductId" es la columna correcta en "queryBarCode"

            ResultSet categoryResultSet = statement.executeQuery(queryCategory);

            while (categoryResultSet.next()) {
                String name = categoryResultSet.getString("Name");
                Category cat = new Category();
                cat.setName(name);
                categoryServ.createCategory(cat);
                productos.add(cat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al leer la base de datos o acceder a los objetos Categoria.");
        }

        return productos;

    }

    @PostMapping("/copyAllCompanies")
    public List<Company> obtenerCompañiasAronium() {

        List<Company> companias = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + rutaAroniumBD); Statement statement = connection.createStatement()) {

            // Consulta SQL para obtener los datos de las columnas necesarias
            String queryCompany = "SELECT Name, StreetName, Address, PostalCode, City, CountryId, "
                    + "TaxNumber, Email, PhoneNumber, BankAccountNumber, BankDetails, "
                    + "AdditionalStreetName, BuildingNumber, PlotIdentification, "
                    + "CitySubdivisionName, CountrySubentity "
                    + "FROM Company";

            ResultSet categoryResultSet = statement.executeQuery(queryCompany);

            while (categoryResultSet.next()) {
                String name = categoryResultSet.getString("Name");
                Company compania = new Company();
                compania.setName(name);
                compania.setStreetName(categoryResultSet.getString("StreetName"));
                compania.setAddress(categoryResultSet.getString("Address"));
                compania.setPostalCode(categoryResultSet.getString("PostalCode"));
                compania.setCityName(categoryResultSet.getString("City"));
                compania.setTaxId(categoryResultSet.getString("TaxNumber"));
                compania.setEmail(categoryResultSet.getString("Email"));
                compania.setPhoneNumber(categoryResultSet.getString("PhoneNumber"));

                companyServ.createCompany(compania);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al leer la base de datos o acceder a los objetos Categoria.");
        }
        return companias;
    }

    @PostMapping("/copyAllCustomers")
    public List<Customer> obtenerClientesAronium() {

        List<Customer> clientes = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + rutaAroniumBD); Statement statement = connection.createStatement()) {

            // Consulta SQL para obtener los datos de las columnas necesarias
            String queryCustomer = "SELECT Name, TaxNumber, Address, PostalCode, City, DateCreated, DateUpdated, Email, PhoneNumber, "
                    + "IsEnabled, IsCustomer, IsSupplier, DueDatePeriod, StreetName, AdditionalStreetName, BuildingNumber "
                    + "FROM Customer";

            ResultSet customerResultSet = statement.executeQuery(queryCustomer);

            while (customerResultSet.next()) {
                // Crear nuevo objeto Customer
                Customer customer = new Customer();

                // Asignar los valores obtenidos del ResultSet a la entidad Customer
                customer.setFirstName(customerResultSet.getString("Name"));  // Si 'Name' representa el nombre completo
                customer.setTaxNumber(customerResultSet.getString("TaxNumber"));
                customer.setAddress(customerResultSet.getString("Address"));
                customer.setPostalCode(customerResultSet.getString("PostalCode"));
                customer.setCity(customerResultSet.getString("City"));
                customer.setCreation_date(customerResultSet.getTimestamp("DateCreated").toLocalDateTime());
                customer.setLast_updated_date(customerResultSet.getTimestamp("DateUpdated").toLocalDateTime());
                customer.setEmail(customerResultSet.getString("Email"));
                customer.setPhoneNumber(customerResultSet.getString("PhoneNumber"));
                customer.setIsEnabled(customerResultSet.getBoolean("IsEnabled"));
                customer.setStreetName(customerResultSet.getString("StreetName"));
                // Otros campos adicionales según la consulta SQL
                // En tu entidad Customer no tienes los campos 'IsCustomer', 'IsSupplier', 'DueDatePeriod', 'AdditionalStreetName', 'BuildingNumber'
                // Si necesitas estos campos, añádelos a la entidad o ignóralos.

                // Guardar cliente en la base de datos
                customerServ.createCustomer(customer);

                // Añadir el objeto Customer a la lista de clientes
                clientes.add(customer);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al leer la base de datos o acceder a los objetos Cliente.");
        }

        return clientes;

    }
//"Tucan2526"
    @PostMapping("/createOwner")
    public Owner crearEvana() {
        Owner evana = new Owner();
        evana.setNickName("evanadik");
        //.setPasswordHash();
        evana.setPasswordHash(ownerServ.encryptPassword("Tucan2526"));
        evana.setName("Evana Raquel");
        evana.setFamilyName("Dikún");
        evana.setMail("gestiones-judiciales@hotmail.com");
        evana.setEnabled(true);
        evana.setAccountNotExpired(true);
        evana.setAccountNotLocked(true);
        evana.setCredentialNotExpired(true);

        // Llama al servicio para guardar el Owner
        ownerServ.createOwner(evana);

        return evana;
    }
    
    
   @PostMapping("/copyAllPayments")
public List<PaymentMethod> paymentMethod() {

    List<PaymentMethod> payments = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + rutaAroniumBD);
         Statement statement = connection.createStatement()) {

        // Consulta SQL para obtener los datos de las columnas necesarias
        String queryPaymentMethod = "SELECT Name, Code, IsCustomerRequired, IsFiscal, IsSlipRequired, IsChangeAllowed, Ordinal, IsEnabled, IsQuickPayment, OpenCashDrawer, ShortcutKey, MarkAsPaid FROM PaymentType";

        ResultSet paymentMethodResultSet = statement.executeQuery(queryPaymentMethod);

        while (paymentMethodResultSet.next()) {
            // Crear nuevo objeto Customer
            PaymentMethod method = new PaymentMethod();
            method.setName(paymentMethodResultSet.getString("Name"));
            method.setCode(paymentMethodResultSet.getString("Code"));
            method.setShortcutKey(paymentMethodResultSet.getString("ShortcutKey"));
            method.setOrdinal(paymentMethodResultSet.getInt("Ordinal"));
            method.setIsEnabled(paymentMethodResultSet.getBoolean("IsEnabled"));

            paymentServ.createPaymentMethod(method);

            // Añadir el objeto method a la lista de metodos de pago
            payments.add(method);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al leer la base de datos o acceder a los objetos Metodos de Pago.");
    }

    return payments;
}

   
    @PostMapping("/copyAllProducts")
    public List<Product> obtenerProductosAronium() {

        List<Product> productos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + rutaAroniumBD); Statement statement = connection.createStatement()) {

            // Consulta SQL para obtener los datos de las columnas necesarias
            String queryBarCode = "SELECT Id, ProductId, Value FROM Barcode";  // Asumiendo que "ProductId" es la columna correcta en "queryBarCode"

            ResultSet barcodeResultSet = statement.executeQuery(queryBarCode);

            while (barcodeResultSet.next()) {
                String idProducto = barcodeResultSet.getString("ProductId");
                String barCode = barcodeResultSet.getString("Value");
                // Consulta SQL para obtener el producto con todas las columnas relevantes
                String queryProduct = "SELECT Id, PLU, Name, DateCreated, DateUpdated, Cost, Price, Markup, isEnabled, Description FROM Product WHERE Id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(queryProduct);
                preparedStatement.setString(1, idProducto);

                // Ejecutar la consulta para obtener el producto
                ResultSet productResultSet = preparedStatement.executeQuery();

                // Verificar si se encontró un producto
                if (productResultSet.next()) {
                    String creacion = productResultSet.getString("DateCreated");
                    String actualizacion = productResultSet.getString("DateUpdated");
                    String PLU = productResultSet.getString("PLU");
                    String nombre = productResultSet.getString("Name");
                    LocalDateTime creation_date = productResultSet.getTimestamp("DateCreated").toLocalDateTime();
                    LocalDateTime last_updated_date = productResultSet.getTimestamp("DateUpdated").toLocalDateTime();

                    /*LocalDateTime creation_date = parsearHoraYFecha("created", creacion);
                    LocalDateTime last_updated_date = parsearHoraYFecha("elsa", actualizacion);*/
                    Double costo = productResultSet.getDouble("Cost");
                    Double precio = productResultSet.getDouble("Price");
                    Double profit_margin = productResultSet.getDouble("Markup");
                    Boolean isEnabled = productResultSet.getBoolean("isEnabled");
                    String detalle = productResultSet.getString("Description");

                    // Crear un objeto Producto con los datos obtenidos
                    Product producto = new Product();
                    producto.setProduct_number(PLU);
                    producto.setName(nombre);
                    producto.setDescription(detalle);
                    producto.setCreation_date(creation_date);
                    producto.setLast_updated_date(last_updated_date);
                    producto.setCost(costo);
                    producto.setPrice(precio);
                    producto.setProfit_margin(profit_margin);
                    producto.setIsEnabled(isEnabled);
                    producto.setCodeBar(barCode);

                    productServ.saveProduct(producto);
                    productos.add(producto);
                } else {
                    // Manejar el caso en que no se encuentra el producto
                    System.out.println("No se encontró un producto con el ID: " + idProducto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al leer la base de datos o acceder a los objetos Producto.");
        }

        return productos;
    }

    public Double makeDouble(String theString) {

        Double newDouble = null;

        try {
            newDouble = Double.valueOf(theString);
            System.out.println("Precio convertido: " + newDouble);
        } catch (NumberFormatException e) {
            System.out.println("El valor ingresado no es un número válido.");
        }
        return newDouble;
    }

    public Integer makeInteger(String theString) {

        Integer newInteger = null;

        try {
            newInteger = Integer.valueOf(theString);
            System.out.println("Precio convertido: " + newInteger);
        } catch (NumberFormatException e) {
            System.out.println("El valor ingresado no es un número válido.");
        }
        return newInteger;
    }

    public LocalDateTime parsearHoraYFecha(String tipo, String dateString) {
        // Definir el formato del DateTimeFormatter
        String usableString = dateString;
        DateTimeFormatter formatter;
        if (tipo.contains("created")) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        } else {
            // Recortar las fracciones de segundo a 6 dígitos
            usableString = truncateFractionalSeconds(dateString, 5);
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss[.SSSSS]");
        }

        // Convertir el String a LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(usableString, formatter);
        return dateTime;
    }

    // Método para recortar las fracciones de segundo a una precisión específica
    private String truncateFractionalSeconds(String dateString, Integer precision) {
        int index = dateString.indexOf('.');
        if (index != -1) {
            // Asegurarse de que la precisión no exceda la longitud real de fracciones de segundo
            int endIndex = Math.min(index + precision + 1, dateString.length());
            return dateString.substring(0, endIndex);
        }
        return dateString;
    }
}
