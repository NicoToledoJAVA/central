# PrivatePOSBack

## Description/Descripción

### English
The present repository is the back end of a POS 
(Point of Sale) application. It is essentially 
the cash register application, so to speak. 
All documentation will be in English and Spanish. 
More endpoints can be created as needed.

### Castellano
El presente repositorio es el back end de una 
aplicación POS (Point of sale, Punto de venta). 
Es la aplicación de la caja registradora, por 
así decirlo. 
Toda la documentación estará en 
inglés y castellano. Se pueden crear más 
endpoints a medida que se van necesitando.

## Index / Índice
1. [Customer / Cliente](#customercontroller)
2. [Payment Type / Método de Pago](#paymenttypecontroller)
3. [Products / Productos](#productcontroller)
4. [Sales / Ventas](#salescontroller)
5. [SalesItem / Detalles de Venta](#salesitemcontroller)
6. [Stock](#stockcontroller)
7. [Category / Categoría](#categorycontroller)
8. [Company / Compañía](#companyController)
9. [User / Usuario](#userController)
10. [Products / Producto](#ownerController)
11. [Tax / Impuesto](#taxController)


---

## CustomerController

### English
**Table**: `customers`

#### Description
This controller manages customer-related operations.  
The `Customer` entity contains client data, including personal information and contact details.

- **Attributes**:
  - `id`: Unique identifier.
  - `firstName`, `lastName`: First name and last name.
  - `address`, `streetName`, `postalCode`, `city`: Address and location details.
  - `email`, `phoneNumber`: Contact information.
  - `isEnabled`: Indicates if the customer is enabled.
  - `idNumber`, `taxNumber`: Tax identification numbers.
- **Relationships**:
  - `List<Sale> sales`: One-to-many relationship with `Sale`.
  - `Owner owner`: Many-to-one relationship with `Owner`, indicating the owner of the customer in the system.

#### Endpoints
- **GET /customers**
  - Retrieves all customers.
- **GET /customers/get/{id}**
  - Retrieves a specific customer by ID.
- **POST /customers/create**
  - Creates a new customer.
- **PUT /customers/modify?id={id}**
  - Updates an existing customer.
- **DELETE /customers/delete/{id}**
  - Deletes a customer by ID.

---

### Castellano
**Tabla**: `customers`

#### Descripción
Este controlador gestiona las operaciones relacionadas con los clientes.  
La entidad `Customer` contiene datos del cliente, incluyendo información personal y detalles de contacto.

- **Atributos**:
  - `id:` Identificador único.
  - `firstName, lastName:` Nombre y apellido.
  - `address, streetName, postalCode, city:` Dirección y ubicación.
  - `email, phoneNumber:` Contacto.
  - `isEnabled:` Estado de habilitación del cliente.
  - `idNumber, taxNumber:` Identificaciones fiscales.
- **Relaciones**:
  - `List<Sale> sales:` Relación uno-a-muchos con `Sale`.
  - `Owner owner:` Relación muchos-a-uno con `Owner`, que indica el dueño del cliente en el sistema.

#### Puntos de entrada
- **GET /customers**
  - Recupera todos los clientes.
- **GET /customers/get/{id}**
  - Recupera un cliente específico por ID.
- **POST /customers/create**
  - Crea un nuevo cliente.
- **PUT /customers/modify?id={id}**
  - Actualiza un cliente existente.
- **DELETE /customers/delete/{id}**
  - Elimina un cliente por ID.

---

## PaymentTypeController

### English
**Table**: `payment_methods`

#### Description
Defines the payment methods accepted by the company (cash, card, etc.).

- **Attributes**:
  - `id`: Unique identifier.
  - `name`: Name of the payment method.
  - `code`: Optional code.
  - `shortcutKey`: Shortcut key.
  - `ordinal`: Priority within the payment system.
  - `isEnabled`: Indicates if the payment method is enabled.
- **Relationships**:
  - `Owner owner`: Many-to-one relationship with `Owner`.

#### Endpoints
- **GET /paymenttypes**
  - Retrieves all payment methods.
- **GET /paymenttypes/get/{id}**
  - Retrieves a specific payment method by ID.
- **POST /paymenttypes/create**
  - Creates a new payment method.
- **PUT /paymenttypes/modify/{id}**
  - Updates an existing payment method.
- **DELETE /paymenttypes/delete/{id}**
  - Deletes a payment method by ID.

---

### Castellano
**Tabla**: `payment_methods`

#### Descripción
Define los métodos de pago que la empresa acepta (efectivo, tarjeta, etc.).

- **Atributos**:
  - `id`: Identificador único.
  - `name`: Nombre del método de pago.
  - `code`: Código opcional.
  - `shortcutKey`: Tecla de acceso directo.
  - `ordinal`: Prioridad en el sistema de pagos.
  - `isEnabled`: Estado de habilitación.
- **Relaciones**:
  - `Owner owner`: Relación muchos-a-uno con `Owner`.

#### Puntos de entrada
- **GET /paymenttypes**
  - Recupera todos los métodos de pago.
- **GET /paymenttypes/get/{id}**
  - Recupera un método de pago específico por ID.
- **POST /paymenttypes/create**
  - Crea un nuevo método de pago.
- **PUT /paymenttypes/modify/{id}**
  - Actualiza un método de pago existente.
- **DELETE /paymenttypes/delete/{id}**
  - Elimina un método de pago por ID.

---

## ProductController

### English
**Table**: `products`

#### Description
This controller manages operations related to `products`.  
The `Product` entity represents the products the company sells.

- **Attributes**:
  - `id_product`: Unique identifier.
  - `product_number`, `codeBar`: Product number and barcode.
  - `name`, `description`: Name and description.
  - `cost`, `price`, `profit_margin`: Cost, price, and profit margin.
- **Relationships**:
  - `Category category`: Many-to-one relationship with `Category`.
  - `Company company`: Many-to-one relationship with `Company`.
  - `Stock stock`: One-to-one relationship with `Stock`.
  - `Owner owner`: Many-to-one relationship with `Owner`.

#### Endpoints
- **POST /products/getListFast**
  - Retrieves a predefined list of products for testing.
- **POST /products/create**
  - Creates a new product.
- **POST /products/getList**
  - Retrieves a limited list of products.
- **POST /products/getAll**
  - Retrieves all products.
- **GET /products/getByCodeBar**
  - Retrieves a product by its barcode.
- **GET /products/getByName**
  - Retrieves products by name.
- **POST /products/deleteAll**
  - Deletes all products with IDs greater than 520.

---

### Castellano
**Tabla**: `products`

#### Descripción
Este controlador gestiona las operaciones relacionadas con los `productos`.  
La entidad `Product` representa los productos que la empresa vende.

- **Atributos**:
  - `id_product`: Identificador único.
  - `product_number`, `codeBar`: Código de barras y número de producto.
  - `name`, `description`: Nombre y descripción.
  - `cost`, `price`, `profit_margin`: Costo, precio y margen de beneficio.
- **Relaciones**:
  - `Category category`: Relación muchos-a-uno con `Category`.
  - `Company company`: Relación muchos-a-uno con `Company`.
  - `Stock stock`: Relación uno-a-uno con `Stock`.
  - `Owner owner`: Relación muchos-a-uno con `Owner`.

#### Puntos de entrada
- **POST /products/getListFast**
  - Recupera una lista predefinida de productos para pruebas.
- **POST /products/create**
  - Crea un nuevo producto.
- **POST /products/getList**
  - Recupera una lista limitada de productos.
- **POST /products/getAll**
  - Recupera todos los productos.
- **GET /products/getByCodeBar**
  - Recupera un producto por su código de barras.
- **GET /products/getByName**
  - Recupera productos por nombre.
- **POST /products/deleteAll**
  - Elimina todos los productos con ID superiores a 520.

---

## SalesController

### English
**Table**: `sales`

#### Description
This controller manages sales-related operations.  
The `Sale` entity represents a complete sales transaction.

- **Attributes**:
  - `id`: Unique identifier.
  - `sale_number`: Sale number.
  - `status`: Sale status.
  - `totalAmount`: Total amount.
- **Relationships**:
  - `List<SaleItem> saleItems`: One-to-many relationship with `SaleItem`.
  - `Customer customer`: Many-to-one relationship with `Customer`.
  - `User seller`: Many-to-one relationship with `User`.
  - `Owner owner`: Many-to-one relationship with `Owner`.

#### Endpoints
- **GET /sales**
  - Retrieves all sales.
- **GET /sales/{id}**
  - Retrieves a specific sale by ID.
- **POST /sales/doSale**
  - Creates a new sale.
- **PUT /sales**
  - Updates an existing sale.
- **DELETE /sales/{id}**
  - Deletes a sale by ID.

---

### Castellano
**Tabla**: `sales`

#### Descripción
Este controlador gestiona las operaciones relacionadas con `ventas`.  
La entidad `Sale` representa una transacción de venta completa.

- **Atributos**:
  - `id`: Identificador único.
  - `sale_number`: Número de venta.
  - `status`: Estado de la venta.
  - `totalAmount`: Monto total.
- **Relaciones**:
  - `List<SaleItem> saleItems`: Relación uno-a-muchos con `SaleItem`.
  - `Customer customer`: Relación muchos-a-uno con `Customer`.
  - `User seller`: Relación muchos-a-uno con `User`.
  - `Owner owner`: Relación muchos-a-uno con `Owner`.

#### Puntos de entrada
- **GET /sales**
  - Recupera todas las ventas.
- **GET /sales/{id}**
  - Recupera una venta específica por ID.
- **POST /sales/doSale**
  - Crea una nueva venta.
- **PUT /sales**
  - Actualiza una venta existente.
- **DELETE /sales/{id}**
  - Elimina una venta por ID.

---

# SalesItemController

### English

## Description
The `SalesItemController` manages individual sale item operations, allowing CRUD operations on sales items, linking them to specific sales records, and ensuring accurate sale details.

**Table**: `sale_items`

- **Attributes**:
  - `id`: Unique identifier.
  - `sale_id`: Sale identifier.
  - `name`: Item name.
  - `description`: Item description.
  - `discount`: Applied discount.
  - `quantity`: Quantity.
  - `price`: Unit price.
  - `owner_id`: Owner identifier.
- **Relationships**:
  - `Sale sale`: Many-to-one relationship with `Sale`.
  - `Owner owner`: Many-to-one relationship with `Owner`.

## Endpoints
### `GET /saleItems`
- **Description**: Retrieves a list of all sales items.
- **Response**: A JSON array of sales items.

### `GET /saleItems/{id}`
- **Description**: Fetches details of a specific sales item by its ID.
- **Parameters**: 
  - `id`: The ID of the sales item.
- **Response**: A JSON object representing the sales item.

### `POST /saleItems`
- **Description**: Creates a new sales item.
- **Request Body**: A JSON object representing the new sales item.
- **Response**: The created sales item object.

### `PUT /saleItems/{id}`
- **Description**: Updates an existing sales item.
- **Parameters**: 
  - `id`: The ID of the sales item to update.
- **Request Body**: A JSON object with updated details.
- **Response**: The updated sales item object.

### `DELETE /saleItems/{id}`
- **Description**: Deletes a specific sales item.
- **Parameters**: 
  - `id`: The ID of the sales item to delete.
- **Response**: A success message or status.

---

### Castellano

## Descripción
El `SalesItemController` gestiona las operaciones individuales de los elementos de venta, permitiendo operaciones CRUD en los artículos de venta, vinculándolos a registros de venta específicos y asegurando detalles precisos de las ventas.

**Tabla**: `sale_items`

- **Atributos**:
  - `id`: Identificador único.
  - `sale_id`: Identificador de la venta.
  - `name`: Nombre del ítem.
  - `description`: Descripción del ítem.
  - `discount`: Descuento aplicado.
  - `quantity`: Cantidad.
  - `price`: Precio unitario.
  - `owner_id`: Identificador del dueño.
- **Relaciones**:
  - `Sale sale`: Relación muchos-a-uno con `Sale`.
  - `Owner owner`: Relación muchos-a-uno con `Owner`.

### `DELETE /saleItems/{id}`
## Endpoints
### `GET /saleItems`
- **Descripción**: Recupera una lista de todos los elementos de venta.
- **Respuesta**: Un arreglo JSON de artículos de venta.

### `GET /saleItems/{id}`
- **Descripción**: Obtiene los detalles de un artículo de venta específico por su ID.
- **Parámetros**: 
  - `id`: El ID del artículo de venta.
- **Respuesta**: Un objeto JSON que representa el artículo de venta.

### `POST /saleItems`
- **Descripción**: Crea un nuevo artículo de venta.
- **Cuerpo de la solicitud**: Un objeto JSON que representa el nuevo artículo de venta.
- **Respuesta**: El objeto del artículo de venta creado.

### `PUT /saleItems/{id}`
- **Descripción**: Actualiza un artículo de venta existente.
- **Parámetros**: 
  - `id`: El ID del artículo de venta a actualizar.
- **Cuerpo de la solicitud**: Un objeto JSON con detalles actualizados.
- **Respuesta**: El objeto del artículo de venta actualizado.

### `DELETE /saleItems/{id}`
- **Descripción**: Elimina un artículo de venta específico.
- **Parámetros**: 
  - `id`: El ID del artículo de venta a eliminar.
- **Respuesta**: Un mensaje de éxito o estado.

---

# StockController

### English

## Description
The `StockController` is responsible for managing inventory levels, including adding new stock, updating existing stock quantities, and retrieving current stock information.

**Table**: `stock`

- **Attributes**:
  - `id`: Unique identifier.
  - `product_id`: Product identifier.
  - `currentStock`: Available product quantity.
  - `restockPoint`: Restock point.
  - `lowStockWarningStatus`: Low stock alert status.
  - `lowStockWarningQuantity`: Low stock alert quantity.
  - `desiredStockLevel`: Desired stock level.
  - `company_id`: Company identifier.
- **Relationships**:
  - `Product product`: One-to-one relationship with `Product`.
  - `Company company`: Many-to-one relationship with `Company`.

## Endpoints
### `GET /stocks`
- **Description**: Retrieves a list of all stock items.
- **Response**: A JSON array of stock items.

### `GET /stocks/{id}`
- **Description**: Fetches details of a specific stock item by its ID.
- **Parameters**: 
  - `id`: The ID of the stock item.
- **Response**: A JSON object representing the stock item.

### `POST /stocks`
- **Description**: Adds new stock to inventory.
- **Request Body**: A JSON object representing the new stock item.
- **Response**: The created stock item object.

### `PUT /stocks/{id}`
- **Description**: Updates stock quantity for an existing item.
- **Parameters**: 
  - `id`: The ID of the stock item to update.
- **Request Body**: A JSON object with updated stock details.
- **Response**: The updated stock item object.

### `DELETE /stocks/{id}`
- **Description**: Removes a specific stock item from inventory.
- **Parameters**: 
  - `id`: The ID of the stock item to delete.
- **Response**: A success message or status.

---

### Castellano

## Descripción
El `StockController` es responsable de gestionar los niveles de inventario, incluyendo agregar nuevo stock, actualizar cantidades de stock existentes y recuperar información actual de inventario.

**Tabla**: `stock`

- **Atributos**:
  - `id`: Identificador único.
  - `product_id`: Identificador del producto.
  - `currentStock`: Cantidad disponible del producto.
  - `restockPoint`: Punto de reposición.
  - `lowStockWarningStatus`: Estado de alerta de bajo stock.
  - `lowStockWarningQuantity`: Cantidad de alerta de bajo stock.
  - `desiredStockLevel`: Nivel de stock deseado.
  - `company_id`: Identificador de la compañía.
- **Relaciones**:
  - `Product product`: Relación uno-a-uno con `Product`.
  - `Company company`: Relación muchos-a-uno con `Company`.

## Endpoints
### `GET /stocks`
- **Descripción**: Recupera una lista de todos los elementos de stock.
- **Respuesta**: Un arreglo JSON de elementos de stock.

### `GET /stocks/{id}`
- **Descripción**: Obtiene los detalles de un elemento de stock específico por su ID.
- **Parámetros**: 
  - `id`: El ID del elemento de stock.
- **Respuesta**: Un objeto JSON que representa el elemento de stock.

### `POST /stocks`
- **Descripción**: Agrega nuevo stock al inventario.
- **Cuerpo de la solicitud**: Un objeto JSON que representa el nuevo elemento de stock.
- **Respuesta**: El objeto del elemento de stock creado.

### `PUT /stocks/{id}`
- **Descripción**: Actualiza la cantidad de stock para un elemento existente.
- **Parámetros**: 
  - `id`: El ID del elemento de stock a actualizar.
- **Cuerpo de la solicitud**: Un objeto JSON con detalles de stock actualizados.
- **Respuesta**: El objeto del elemento de stock actualizado.

### `DELETE /stocks/{id}`
- **Descripción**: Elimina un elemento de stock específico del inventario.
- **Parámetros**: 
  - `id`: El ID del elemento de stock a eliminar.
- **Respuesta**: Un mensaje de éxito o estado.

---

# CategoryController

### English

## Description
The `CategoryController` manages product categories, allowing you to create, view, update, and delete product categories for better inventory organization.

**Table**: `categories`

- **Attributes**:
  - `id`: Unique identifier.
  - `name`: Category name.
  - `owner_id`: Owner identifier.
- **Relationships**:
  - `List<Product> products`: One-to-many relationship with `Product`.
  - `Owner owner`: Many-to-one relationship with `Owner`.

## Endpoints
### `GET /categories`
- **Description**: Retrieves a list of all product categories.
- **Response**: A JSON array of categories.

### `GET /categories/{id}`
- **Description**: Fetches details of a specific category by its ID.
- **Parameters**: 
  - `id`: The ID of the category.
- **Response**: A JSON object representing the category.

### `POST /categories`
- **Description**: Creates a new product category.
- **Request Body**: A JSON object representing the new category.
- **Response**: The created category object.

### `PUT /categories/{id}`
- **Description**: Updates an existing product category.
- **Parameters**: 
  - `id`: The ID of the category to update.
- **Request Body**: A JSON object with updated category details.
- **Response**: The updated category object.

### `DELETE /categories/{id}`
- **Description**: Deletes a specific product category.
- **Parameters**: 
  - `id`: The ID of the category to delete.
- **Response**: A success message or status.

---

### Castellano

## Descripción
El `CategoryController` gestiona las categorías de productos, permitiendo crear, ver, actualizar y eliminar categorías de productos para una mejor organización del inventario.

**Tabla**: `categories`

- **Atributos**:
  - `id`: Identificador único.
  - `name`: Nombre de la categoría.
  - `owner_id`: Identificador del dueño.
- **Relaciones**:
  - `List<Product> products`: Relación uno-a-muchos con `Product`.
  - `Owner owner`: Relación muchos-a-uno con `Owner`.

## Endpoints
### `GET /categories`
- **Descripción**: Recupera una lista de todas las categorías de productos.
- **Respuesta**: Un arreglo JSON de categorías.

### `GET /categories/{id}`
- **Descripción**: Obtiene los detalles de una categoría específica por su ID.
- **Parámetros**: 
  - `id`: El ID de la categoría.
- **Respuesta**: Un objeto JSON que representa la categoría.

### `POST /categories`
- **Descripción**: Crea una nueva categoría de producto.
- **Cuerpo de la solicitud**: Un objeto JSON que representa la nueva categoría.
- **Respuesta**: El objeto de la categoría creada.

### `PUT /categories/{id}`
- **Descripción**: Actualiza una categoría de producto existente.
- **Parámetros**: 
  - `id`: El ID de la categoría a actualizar.
- **Cuerpo de la solicitud**: Un objeto JSON con detalles de la categoría actualizados.
- **Respuesta**: El objeto de la categoría actualizada.

### `DELETE /categories/{id}`
- **Descripción**: Elimina una categoría de producto específica.
- **Parámetros**: 
  - `id`: El ID de la categoría a eliminar.
- **Respuesta**: Un mensaje de éxito o estado.

---

# CompanyController

### English
**Table**: `Companies`

#### Description
This controller manages company-related operations.  
The `Company` entity includes information about the companies, such as address, tax, and contact details.

- **Attributes**:
  - `id`: Unique identifier.
  - `name`: Name of the company.
  - `address`, `streetName`, `postalCode`, `BuildingNumber`, `cityName`: Location details.
  - `taxId`: Tax identification.
  - `email`, `phoneNumber`: Contact information.
  - `logoUrl`: Link to the company logo.
- **Relationships**:
  - `List<Product> products`: One-to-many relationship with `Product`.
  - `List<Tax> taxes`: One-to-many relationship with `Tax`.
  - `List<Stock> stocks`: One-to-many relationship with `Stock`.
  - `Owner owner`: Many-to-one relationship with `Owner`, indicating the company's owner.

#### Endpoints
- **GET /companies**
  - Retrieves all companies.
- **GET /companies/get/{id}**
  - Retrieves a specific company by ID.
- **POST /companies/create**
  - Creates a new company.
- **PUT /companies/modify**
  - Updates an existing company.
- **DELETE /companies/{id}**
  - Deletes a company by ID.

---

### Castellano
**Tabla**: `Companies`

#### Descripción
Este controlador gestiona las operaciones relacionadas con las compañías.  
La entidad `Company` incluye información sobre las empresas, como dirección, impuestos y detalles de contacto.

- **Atributos**:
  - `id`: Identificador único.
  - `name`: Nombre de la empresa.
  - `address`, `streetName`, `postalCode`, `BuildingNumber`, `cityName`: Detalles de la ubicación.
  - `taxId`: Identificación fiscal.
  - `email`, `phoneNumber`: Información de contacto.
  - `logoUrl`: Enlace al logo de la empresa.
- **Relaciones**:
  - `List<Product> products`: Relación uno-a-muchos con `Product`.
  - `List<Tax> taxes`: Relación uno-a-muchos con `Tax`.
  - `List<Stock> stocks`: Relación uno-a-muchos con `Stock`.
  - `Owner owner`: Relación muchos-a-uno con `Owner`, que indica el dueño de la empresa.

#### Puntos de entrada
- **GET /companies**
  - Recupera todas las empresas.
- **GET /companies/get/{id}**
  - Recupera una empresa específica por ID.
- **POST /companies/create**
  - Crea una nueva empresa.
- **PUT /companies/modify**
  - Actualiza una empresa existente.
- **DELETE /companies/{id}**
  - Elimina una empresa por ID.

---

# UserController

### English
**Table**: `Users`

#### Description
This controller manages user-related operations.  
The `User` entity holds data on system users, including authentication and personal details.

- **Attributes**:
  - `id`: Unique identifier.
  - `userName`: User's username.
  - `passwordHash`: Hashed password.
  - `firstName`, `lastName`: User's first and last names.
  - `id_number`: User's identification number.
  - `enabled`, `accountNotExpired`, `accountNotLocked`, `credentialNotExpired`: User account statuses.
- **Relationships**:
  - `List<Sale> userSalesList`: One-to-many relationship with `Sale`.
  - `Owner owner`: Many-to-one relationship with `Owner`, indicating the user's owner.

#### Endpoints
- **GET /users**
  - Retrieves all users.
- **GET /users/get/{id}**
  - Retrieves a specific user by ID.
- **POST /users/create**
  - Creates a new user.
- **PUT /users/limitMod**
  - Updates limited fields of an existing user.
- **DELETE /users/{id}**
  - Deletes a user by ID.

---

### Castellano
**Tabla**: `Users`

#### Descripción
Este controlador gestiona las operaciones relacionadas con los usuarios.  
La entidad `User` contiene datos sobre los usuarios del sistema, incluyendo detalles de autenticación y personales.

- **Atributos**:
  - `id`: Identificador único.
  - `userName`: Nombre de usuario.
  - `passwordHash`: Contraseña encriptada.
  - `firstName`, `lastName`: Nombre y apellido del usuario.
  - `id_number`: Número de identificación del usuario.
  - `enabled`, `accountNotExpired`, `accountNotLocked`, `credentialNotExpired`: Estados de la cuenta del usuario.
- **Relaciones**:
  - `List<Sale> userSalesList`: Relación uno-a-muchos con `Sale`.
  - `Owner owner`: Relación muchos-a-uno con `Owner`, que indica el dueño del usuario.

#### Puntos de entrada
- **GET /users**
  - Recupera todos los usuarios.
- **GET /users/get/{id}**
  - Recupera un usuario específico por ID.
- **POST /users/create**
  - Crea un nuevo usuario.
- **PUT /users/limitMod**
  - Actualiza campos limitados de un usuario existente.
- **DELETE /users/{id}**
  - Elimina un usuario por ID.

  ---

# OwnerController

### English
**Table**: `Owners`

#### Description
This controller manages owner-related operations.  
The `Owner` entity includes details on owners, such as personal information and account status.

- **Attributes**:
  - `id`: Unique identifier.
  - `owners_nickName`: Unique nickname for the owner.
  - `name`, `familyName`: Owner’s first and last names.
  - `mail`: Owner’s email, unique.
  - `enabled`, `accountNotExpired`, `accountNotLocked`, `credentialNotExpired`: Status attributes for the owner account.
- **Relationships**:
  - `List<Category> categories`: One-to-many relationship with `Category`.
  - `List<Company> companies`: One-to-many relationship with `Company`.
  - `List<Customer> customers`: One-to-many relationship with `Customer`.
  - `List<PaymentMethod> paymentMethods`: One-to-many relationship with `PaymentMethod`.
  - `List<Product> products`: One-to-many relationship with `Product`.
  - `List<Sale> sales`: One-to-many relationship with `Sale`.
  - `List<User> users`: One-to-many relationship with `User`.

#### Endpoints
- **GET /owners**
  - Retrieves all owners.
- **GET /owners/get/{id}**
  - Retrieves a specific owner by ID.
- **POST /owners/create**
  - Creates a new owner.
- **PUT /owners/modify**
  - Updates an existing owner.
- **DELETE /owners/{id}**
  - Deletes an owner by ID.

---

### Castellano
**Tabla**: `Owners`

#### Descripción
Este controlador gestiona las operaciones relacionadas con los propietarios.  
La entidad `Owner` contiene detalles sobre los propietarios, incluyendo información personal y el estado de la cuenta.

- **Atributos**:
  - `id`: Identificador único.
  - `owners_nickName`: Apodo único del propietario.
  - `name`, `familyName`: Nombre y apellido del propietario.
  - `mail`: Correo electrónico del propietario, único.
  - `enabled`, `accountNotExpired`, `accountNotLocked`, `credentialNotExpired`: Estados de la cuenta del propietario.
- **Relaciones**:
  - `List<Category> categories`: Relación uno-a-muchos con `Category`.
  - `List<Company> companies`: Relación uno-a-muchos con `Company`.
  - `List<Customer> customers`: Relación uno-a-muchos con `Customer`.
  - `List<PaymentMethod> paymentMethods`: Relación uno-a-muchos con `PaymentMethod`.
  - `List<Product> products`: Relación uno-a-muchos con `Product`.
  - `List<Sale> sales`: Relación uno-a-muchos con `Sale`.
  - `List<User> users`: Relación uno-a-muchos con `User`.

#### Puntos de entrada
- **GET /owners**
  - Recupera todos los propietarios.
- **GET /owners/get/{id}**
  - Recupera un propietario específico por ID.
- **POST /owners/create**
  - Crea un nuevo propietario.
- **PUT /owners/modify**
  - Actualiza un propietario existente.
- **DELETE /owners/{id}**
  - Elimina un propietario por ID.

---

# TaxController

### English
**Table**: `Taxes`

#### Description
This controller manages tax-related operations.  
The `Tax` entity holds data on taxes, including name and rate.

- **Attributes**:
  - `id`: Unique identifier.
  - `name`: Name of the tax (e.g., VAT).
  - `rate`: Tax rate (e.g., 21% for VAT).
- **Relationships**:
  - `Company company`: Many-to-one relationship with `Company`.

#### Endpoints
- **GET /taxes**
  - Retrieves all taxes.
- **GET /taxes/get/{id}**
  - Retrieves a specific tax by ID.
- **POST /taxes/create**
  - Creates a new tax.
- **PUT /taxes/modify**
  - Updates an existing tax.
- **DELETE /taxes/{id}**
  - Deletes a tax by ID.

---

### Castellano
**Tabla**: `Taxes`

#### Descripción
Este controlador gestiona las operaciones relacionadas con los impuestos.  
La entidad `Tax` contiene información sobre los impuestos, como el nombre y la tasa.

- **Atributos**:
  - `id`: Identificador único.
  - `name`: Nombre del impuesto (Ej: IVA).
  - `rate`: Tasa del impuesto (por ejemplo, 21% para IVA).
- **Relaciones**:
  - `Company company`: Relación muchos-a-uno con `Company`.

#### Puntos de entrada
- **GET /taxes**
  - Recupera todos los impuestos.
- **GET /taxes/get/{id}**
  - Recupera un impuesto específico por ID.
- **POST /taxes/create**
  - Crea un nuevo impuesto.
- **PUT /taxes/modify**
  - Actualiza un impuesto existente.
- **DELETE /taxes/{id}**
  - Elimina un impuesto por ID.

  ---
