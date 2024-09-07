import java.util.Scanner;

class EcommerceSystem {
    User users[] = new User[20];
    Product products[] = new Product[100];
    int users_count, prodcuts_count;

    User getUser(String username) {
        for (User user : users) {
            if (user != null) {
                if (user.username.compareToIgnoreCase(username) == 0) {
                    return user;
                }
            }
        }
        return null;
    }

    Product getProduct(int uid) {
        for (Product product : products) {
            if (product != null) {
                if (product.uid == uid) {
                    return product;
                }
            }
        }
        return null;
    }

    User login(String username, String password) {
        if (getUser(username).passwrod.compareTo(password) == 0) {
            return getUser(username);
        }
        return null;
    }

    void printAllProducts(boolean sort, boolean sortAscending, boolean filter, double filterPriceLow,
            double filterPriceHigh, boolean search, String searchQuery) {

        Product temp_product[] = products.clone();
        if (sort) {
            if (sortAscending) {
                for (int i = 0; i < prodcuts_count; i++) {
                    for (int j = 0; j < prodcuts_count - i - 1; j++) {
                        if (temp_product[j].price > temp_product[j + 1].price) {
                            Product temp = temp_product[j];
                            temp_product[j] = temp_product[j + 1];
                            temp_product[j + 1] = temp;
                        }
                    }
                }
            } else {
                for (int i = 0; i < prodcuts_count; i++) {
                    for (int j = 0; j < prodcuts_count - i - 1; j++) {
                        if (temp_product[j].price < temp_product[j + 1].price) {
                            Product temp = temp_product[j];
                            temp_product[j] = temp_product[j + 1];
                            temp_product[j + 1] = temp;
                        }
                    }
                }
            }
        }

        if (filter) {
            for (int i = 0; i < temp_product.length; i++) {
                if (temp_product[i] != null) {
                    if (temp_product[i].price > filterPriceHigh || temp_product[i].price < filterPriceLow) {
                        temp_product[i] = null;
                    }
                }
            }
        }

        if (search) {
            for (int i = 0; i < temp_product.length; i++) {
                if (temp_product[i] != null) {
                    if (!temp_product[i].name.toLowerCase().contains(searchQuery)
                            && !temp_product[i].description.toLowerCase().contains(searchQuery)) {
                        temp_product[i] = null;
                    }
                }
            }
        }

        for (Product product : temp_product) {
            if (product != null) {
                System.out.printf("%d\t%-80s\t\t\t\tRs.%f\n\n", product.uid, product.name, product.price);
            }
        }
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------");
    }

    User registerUser(String name, String username, String password) {
        User user = new User(name, username, password);
        return addUser(user);
    }

    User addUser(User user) {
        return users[users_count++] = user;
    }

    Product addProduct(String name, String description, double price) {
        Product temp_product = new Product(name, description, price);
        products[prodcuts_count++] = temp_product;
        return temp_product;
    }

    class User {
        String name, username, passwrod;
        int uid;
        static int count = 0;
        {
            count++;
        }

        User(String name, String username, String password) {
            this.name = name;
            this.username = username;
            this.passwrod = password;
        }
    }

    class Product {
        String name, description;
        double price, rating;
        int uid;
        static int count = 0;
        {
            count++;
        }

        Product(String name, String description, double price) {
            this.uid = count;
            this.price = price;
            this.name = name;
            this.description = description;
            this.uid = count;
        }

        void print() {
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------");
            System.out.println("PRODUCT UID - " + this.uid);
            System.out.printf("PRODUCT NAME - %s\n", this.name);
            System.out.printf("PRODUCT DESCRIPTION - %s\n", this.description);
            System.out.printf("PRODUCT PRICE - Rs. %f\n", this.price);
            System.out.println(
                    "\n------------------------------------------------------------------------------------------------------------------------");
        }
    }
}

class CartItem {
    EcommerceSystem.Product product;
    int quantity;

    CartItem(EcommerceSystem.Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

class Ecommerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EcommerceSystem esys = new EcommerceSystem();
        esys.addUser(esys.new User("Het", "h", "h"));

        String products[][] = {
                { "KHUSHAL K kurta and palazzo",
                        "Ethnic motifs embroidered anarkali shape pleated style 3/4th sleeves round neck", "1525" },
                { "Libas Printed Kurta",
                        "Our blue floral print straight fit cotton kurta features a round neckline and 3/4 sleeves.This ideal style is ideal for everyday daily wear",
                        "1499" },
                { "Here&now skirt",
                        "A combination of complex techniques and feminine detailing  decorated with a paisley print",
                        "1799" },
                { "SHRIMAY Sarees women cotton silk Saree",
                        "The saree has been delicately crafted from a silk blended fabric. This ensures a comfortable finish and a soft feel. It makes the saree ideal to wear throughout the day, with style.This saree has a matching blouse piece that can be conveniently stitched to complete the outfit. The blouse elegantly coordinates with the shades and tone of the saree, and stylishly adds to its overall look.",
                        "1049" },
                { "Janasya Women's Yellow Poly Crepe Chevron/Zig Zag Crop Top with Palazzo and Jacket",
                        "Feel pretty like never before by wearing this yellow color crop top, jacket and palazzo set by Janasya",
                        "2949" },
                { "WEALTHY WOMEN Gown",
                        "georgette Febric with linning with digital print With golden readymade lace round neck",
                        "849" },
                { "Arayna Women's Kurti with Palazzo",
                        "The beautifully handcrafted hand screen printed Anarkali dress from the house of Arayna will make you the star of wedding parties",
                        "1200" },
                { "ANNI DESIGNER Kurta with Pant & Dupatta",
                        "ANNI DESIGNER Women's Cotton Blend Straight Embroidered Kurta with Pant & Dupatta", "1599" },
                { "GoSriKi Women's Cotton Kurta",
                        "GoSriKi Women's Ruby Cotton Straight Solid Kurta with Palazzo & Dupatta", "2099" },
                { "NeedleTale Kurta for Women",
                        "When one thinks of the Long Kurti one thinks comfort. The high comfort factor is what makes the Kurti a form of clothing loved by all",
                        "899" },
                { "BIBA Women Dress", "BIBA Women's Ethnic Wear Maroon Polyester Dress", "3099" },
                { "Miss Ethnik Women's  Georgette Jacket", "Pakistani Salwar Suit", "1899" },
                { "ANNI DESIGNER Women's Cotton Blend Anarkali",
                        "ANNI DESIGNER Women's Cotton Blend Anarkali Solid Kurta with Dupatta (Aadhya)", "2200" },
                { "BIBA Women's Cotton Kurta",
                        "a very stylish dress cum kurta it comes featuring v-neck and three-fourth sleeves", "2699" },
                { "SANGOURI Women's Sharara Kurti Set",
                        "Kurta & Sharara set beautiful all season outfit with eye relieving light colors is a perfect wear for women for their Casual wear",
                        "1300" },
                { "Vishudh dress",
                        "Green ethinic motifs self design a- line dress with madarin collar with Three-quarter,regular sleeves and viscose rayon material",
                        "588" },
                { "Varanga Women Printed Kurta",
                        "Purple and White bandhani printed round neck Three quarter,regular sleeve with cotton material",
                        "791" },
                { "Indo Era Women Kurta with palazoo and dupatta",
                        "White floral yoke design with round neck Kurta with solid palazzos with partially elasticated waistband with dupatta",
                        "1919" },
                { "Anouk Women Printed Kurta", "Pink printed kurta,has a V-neck and 100% cotton material", "629" },
                { "AADVIKA floral Mysore silk saree",
                        "The saree comes with an unstitched blouse piece and with yellow and red colour", "589" },
                { "Aawari paisley printed gotta patti kurta",
                        "The kurta is with ethinic motifs printed with round neck regular sleeves and viscose rayon material",
                        "775" },
                { "Aarsha Women crepe kurta",
                        "This kurta is black coloured with maroon stripes , mandarin collar and regular sleeves ",
                        "689" },
                { "Amydus Women checked cotton kurta",
                        "This kurta is checked black in colour with regular sleeve and cotton material", "1699" },
                { "Charukriti pure cotton saree",
                        "This saree is white in colour with cream striped and pure cotton material comes with unstitched blouse",
                        "1757" },
                { "Anubhtee Women kurta with trousers & with dupatta",
                        "Kurta is navy blue in colour with ethinic motifs embroided, Anarkali shaped and round neck comes with printed trousers and dupatta .",
                        "999" },
                { "Ethinic Street Women Kurta", "This kurta is round neck, black in colour and pure rayon material",
                        "799" },
                { "Ethinic yard Bandhani printed silk blend saree",
                        "It is Bandhani saree with green colour and purple and turquoise blue deign comes with unstitched blouse piece",
                        "549" },
                { "Linen Club women ethinic kurta with Palazoos",
                        "This kurta is maroon in colour with ethinic motifs printed, V-neck and linen knitted with printed Palazoo",
                        "3099" },
                { "Jaipuri kurti Women printed straight kurta",
                        "This kurta is blue and green printed,has a round neck with hook and with cotton material",
                        "610" },
                { "Anouk Woman printed straight kurta",
                        "This kurta is printed pink in colour and has V-neck with 100% cotton material", "629" } };
        for (int i = 0; i < products.length; i++) {
            esys.addProduct(products[i][0], products[i][1], Double.parseDouble(products[i][2]));
        }
        // Login / Signup
        String username, password;
        System.out.println("Welcome to eCommerce on CLI!");

        while (true) {
            System.out.println(
                    "\n--------------------------------------------------------------------------------------------");
            System.out.print("\n1: Login\n2: Sign Up\n\n>> ");
            int choice = sc.nextInt();
            if (choice == 1) {
                // code for login
                System.out.print("\nUsername: ");
                username = sc.next().toLowerCase();
                if (esys.getUser(username) != null) {

                    System.out.print("Password: ");
                    password = sc.next();
                    EcommerceSystem.User user = esys.login(username, password);
                    if (user != null) {
                        System.out.printf(
                                "\nLog in successfull!");
                        boolean sort, sortAscending, filter, search;
                        String searchQuery = "";
                        double filterPriceLow, filterPriceHigh;
                        filterPriceLow = filterPriceHigh = 0;
                        filter = sort = sortAscending = search = false;
                        CartItem cart[] = new CartItem[100];
                        int cart_count = 0;
                        System.out.printf(
                                "\n--------------------------------------------------------------------------------------------\nHello @%s!\n",
                                username);
                        while (true) {
                            if (true) {
                                System.out
                                        .print("\n1: Explore Store\n2: View your cart\n3: Log Out\n\n>> ");
                                int choice1 = sc.nextInt();
                                if (choice1 == 1) {
                                    while (true) {
                                        System.out.println(
                                                "\n--------------------------------------------------------------EXPLORE--------------------------------------------------------------\n");
                                        // prints all products
                                        esys.printAllProducts(sort, sortAscending, filter, filterPriceLow,
                                                filterPriceHigh, search, searchQuery);
                                        System.out.print(
                                                "\n1: View a product\n2: Search\n3: Filter Settings\n4: Sort Settings\n5: Back\n\n>> ");
                                        int choice2 = sc.nextInt();
                                        if (choice2 == 1) {
                                            // print a product
                                            System.out.print("Enter UID of product >> ");
                                            int product_uid = sc.nextInt();
                                            EcommerceSystem.Product product = esys.getProduct(product_uid);
                                            if (product != null) {
                                                while (true) {
                                                    product.print();
                                                    System.out.print(
                                                            "\n1: Add to cart\n2: Back\n\n>> ");
                                                    int choice4 = sc.nextInt();
                                                    if (choice4 == 1) {
                                                        int quantity;
                                                        while (true) {
                                                            System.out.print("Enter number of piece >> ");
                                                            quantity = sc.nextInt();
                                                            if (quantity > 10 || quantity < 0) {
                                                                System.out.println(
                                                                        "\nQuantitly must not exceed 10 and must be above 0!");
                                                            } else {
                                                                cart[cart_count++] = new CartItem(product, quantity);
                                                                System.out.printf("\nAdded to cart!\n\n");
                                                                break;
                                                            }
                                                        }
                                                    } else if (choice4 == 2) {
                                                        break;
                                                    }
                                                }
                                            } else {
                                                System.out.println("Please enter valid UID!");
                                            }
                                        } else if (choice2 == 2) {
                                            System.out.printf(
                                                    "\n1: Current Query: %s\n2: Clear Search Query\n3: Back\n\n>> ",
                                                    (searchQuery.length() == 0) ? "EMPTY" : searchQuery);
                                            int choice3 = sc.nextInt();
                                            if (choice3 == 1) {
                                                sc.nextLine();
                                                System.out.print("\nEnter new query >> ");
                                                searchQuery = sc.nextLine();
                                                search = true;
                                            } else if (choice3 == 2) {
                                                search = false;
                                                searchQuery = "";
                                            } else if (choice3 == 3) {
                                            } else {
                                                System.out.println("\n Please enter correct choice!");
                                            }
                                        } else if (choice2 == 3) {
                                            System.out.printf(
                                                    "\n----------FILTER SETTINGS----------\n\n1: Minimum price - %f\n2: Maximum price - %f\n3: Clear filter\n4: Back\n>> ",
                                                    filterPriceLow, filterPriceHigh);
                                            int choice3 = sc.nextInt();
                                            if (choice3 == 1) {
                                                filter = true;
                                                while (true) {
                                                    System.out.print("\nEnter minimum price >> ");
                                                    filterPriceLow = sc.nextDouble();
                                                    if (filterPriceLow < 0) {
                                                        System.out.println("\nPrice cant be smaller than 0!");
                                                        continue;
                                                    }
                                                    if (filterPriceHigh < filterPriceLow) {
                                                        System.out.println(
                                                                "\nMinimum price cant be greater than maximum price!");
                                                        while (true) {
                                                            System.out.print("\nEnter maximum price >> ");
                                                            filterPriceHigh = sc.nextDouble();
                                                            if (filterPriceHigh < 0) {
                                                                System.out
                                                                        .println("\nPrice cant be smaller than 0!");
                                                                continue;
                                                            }
                                                            if (filterPriceHigh < filterPriceLow) {
                                                                System.out.println(
                                                                        "\nMinimum price cant be greater than maximum price!");
                                                                continue;
                                                            }
                                                            if (filterPriceHigh > filterPriceLow) {
                                                                break;
                                                            }
                                                        }
                                                        continue;
                                                    }
                                                    if (filterPriceHigh > filterPriceLow) {
                                                        break;
                                                    }
                                                }
                                            } else if (choice3 == 2) {
                                                filter = true;
                                                while (true) {
                                                    System.out.print("\nEnter maximum price >> ");
                                                    filterPriceHigh = sc.nextDouble();
                                                    if (filterPriceHigh < 0) {
                                                        System.out.println("\nPrice cant be smaller than 0!");
                                                        continue;
                                                    }
                                                    if (filterPriceHigh < filterPriceLow) {
                                                        System.out.println(
                                                                "\nMinimum price cant be greater than maximum price!");
                                                        continue;
                                                    }
                                                    if (filterPriceHigh > filterPriceLow) {
                                                        break;
                                                    }
                                                }
                                            } else if (choice3 == 3) {
                                                filter = false;
                                                filterPriceLow = filterPriceHigh = 0;
                                            } else if (choice3 == 4) {

                                            } else {
                                                System.out.println("Please enter valid choice!");
                                            }
                                        } else if (choice2 == 4) {
                                            System.out.print(
                                                    "\n----------SORTING SETTINGS----------\n\n1: Price high to low\n2: Price low to high\n3: Don't sort\n4: Back\n>> ");
                                            int choice3 = sc.nextInt();
                                            if (choice3 == 1) {
                                                sort = true;
                                                sortAscending = false;
                                            } else if (choice3 == 2) {
                                                sort = sortAscending = true;
                                            } else if (choice3 == 3) {
                                                sort = false;
                                            } else if (choice3 == 4) {

                                            } else {
                                                System.out.println("Please enter valid choice!");
                                            }
                                        } else if (choice2 == 5) {
                                            break;
                                        } else {
                                            System.out.println("Please enter valid choice!");
                                        }
                                    }

                                } else if (choice1 == 2) {
                                    while (true) {
                                        System.out.println(
                                                "\n----------------------------------------------------------------------------YOUR CART----------------------------------------------------------------------------\n");
                                        System.out.printf(
                                                "\nUID\t%-80s\t\t%-10s\t\t%-10s\t\t%-10s\n", "NAME", "PRICE",
                                                "QUNATITY", "AMOUNT");
                                        if (cart_count == 0) {
                                            System.out.printf("\n---\t%-80s\t\t%-10s\t\t%-10s\t\t%-10s\n", "----",
                                                    "-----", "--------", "------");
                                            System.out.println(
                                                    "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                                        } else {
                                            double total_amount = 0;
                                            for (int i = 0; i < cart.length; i++) {
                                                if (cart[i] != null) {
                                                    total_amount += cart[i].product.price * cart[i].quantity;
                                                    System.out.printf(
                                                            "\n%d\t%-80s\t\t%-10s\t\t%-10s\t\t%-10f\n",
                                                            cart[i].product.uid,
                                                            cart[i].product.name,
                                                            cart[i].product.price, cart[i].quantity,
                                                            cart[i].product.price * cart[i].quantity);
                                                }
                                            }
                                            System.out.printf(
                                                    "\n%s\t%-80s\t\t%-10s\t\t%-10s\t\t%-10f\n", "", "", "", "",
                                                    total_amount);
                                            System.out.println(
                                                    "\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                                        }
                                        System.out.print(
                                                "\n1: Remove Product\n2: Clear cart\n3: Navigate Back\n\n>> ");
                                        int choice2 = sc.nextInt();
                                        if (choice2 == 1) {
                                            if (cart_count != 0) {
                                                System.out.print("\nEnter UID of item >> ");
                                                int item_uid = sc.nextInt();
                                                boolean item_found = false;
                                                for (CartItem cartItem : cart) {
                                                    if (cartItem != null) {
                                                        if (cartItem.product.uid == item_uid) {
                                                            item_found = true;
                                                        }
                                                    }
                                                }
                                                if (item_found) {
                                                    for (int i = 0; i < cart.length; i++) {
                                                        if (cart[i] != null && cart[i].product.uid == item_uid) {
                                                            cart[i] = null;
                                                            cart_count--;
                                                        }
                                                    }
                                                    CartItem temp[] = new CartItem[cart.length];
                                                    int temp_count = 0;
                                                    for (CartItem i : cart) {
                                                        if (i != null) {
                                                            temp[temp_count++] = i;
                                                        }
                                                    }
                                                    cart = temp;
                                                    System.out.println("\nItem removed!");
                                                } else {
                                                    System.out.println("\nPlease enter valid UID!");
                                                }
                                            } else {
                                                System.out.println("\nCannot remove an item if none are there!");
                                            }
                                        } else if (choice2 == 2) {
                                            cart = new CartItem[100];
                                            cart_count = 0;
                                        } else if (choice2 == 3) {
                                            break;
                                        } else {
                                            System.out.println("\nPlease enter valid choice!");
                                        }
                                    }
                                } else if (choice1 == 3) {
                                    break;
                                } else {
                                    System.out.println("Please enter valid choice!");
                                }
                            }
                        }
                    } else {
                        System.out.println("\nPassword is incorrect please re-enter!");
                    }
                } else {
                    System.out.printf("\n@%s does not exist\nPlease sign up or try another account!", username);
                }
            } else if (choice == 2) {
                // code for sign up
                System.out.println("----------ENTER YOUR DETAILS----------");

                String temp_name, temp_password, temp_re_enter_password, temp_username, temp_type;
                System.out.print("Name: ");
                sc.nextLine();
                temp_name = sc.nextLine();

                while (true) {
                    System.out.print("Username: ");
                    temp_username = sc.nextLine();
                    if (esys.getUser(temp_username) != null) {
                        System.out.println(
                                "\nA user already exists with same username. Please select different username!");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.print("Password: ");
                    temp_password = sc.nextLine();

                    System.out.print("Re-enter Password: ");
                    temp_re_enter_password = sc.nextLine();

                    if (temp_password.compareTo(temp_re_enter_password) == 0) {
                        break;
                    } else {
                        System.out.println("\nPasswords are not matching!\n");
                    }
                }
                esys.registerUser(temp_name, temp_username, temp_password);
            } else {
                System.out.println("\nPlease enter valid choice!");
            }
        }
    }
}