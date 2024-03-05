package org.example.EjemplosPruebas;

import org.example.model.Category;
import org.example.model.Client;
import org.example.model.Post;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PostService postService = new PostService();
    private static final ClientService clientService = new ClientService();
    private static final CategoryService categoryService = new CategoryService();

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            printMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    createPost(scanner);
                    break;
                case 2:
                    readPost(scanner);
                    break;
                case 3:
                    updatePost(scanner);
                    break;
                case 4:
                    deletePost(scanner);
                    break;
                case 5:
                    assignCategoryToPost(scanner);
                    break;
                case 6:
                    createClient();
                    break;
                case 7:
                    readClient();
                    break;
                case 8:
                    updateClient();
                    break;
                case 9:
                    deleteClient();
                    break;
                case 10:
                    createCategory();
                    break;
                case 11:
                    readCategory();
                    break;
                case 12:
                    updateCategory();
                    break;
                case 13:
                    deleteCategory();
                    break;
                case 14:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Crear Post");
        System.out.println("2. Leer Post");
        System.out.println("3. Actualizar Post");
        System.out.println("4. Eliminar Post");
        System.out.println("5. Asignar Categoría a un Post");
        System.out.println("6. Crear Cliente");
        System.out.println("7. Leer Cliente");
        System.out.println("8. Actualizar Cliente");
        System.out.println("9. Eliminar Cliente");
        System.out.println("10. Crear Categoría");
        System.out.println("11. Leer Categoría");
        System.out.println("12. Actualizar Categoría");
        System.out.println("13. Eliminar Categoría");
        System.out.println("14. Salir");
        System.out.print("Ingrese su opción: ");
    }
// ======================================= POSTS =========================================================
    private static void createPost(Scanner scanner) {
        try {
            System.out.print("Enter title: ");
            String title = Menu.scanner.nextLine();

            System.out.print("Enter contenido: ");
            String contenido = scanner.nextLine();

            // Get client to assign to post
            System.out.print("Enter client id: ");
            int clientId = Integer.parseInt(Menu.scanner.nextLine());

            Client client = clientService.getClient(clientId);

            // Create post with client
            Post post = new Post(title, contenido, client);
            postService.createPost(post);

            System.out.println("Post created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   

    private static void readPost(Scanner scanner) {
        try {
            System.out.print("Enter post id: ");
            int id = scanner.nextInt();

            Post post = postService.get(id);

            if (post != null) {
                System.out.println(post);
            } else {
                System.out.println("Post not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updatePost(Scanner scanner) {
        try {
            System.out.print("Enter post id: ");
            int id = scanner.nextInt();

            System.out.print("Enter new title (leave empty to not change): ");
            String title = scanner.nextLine().trim();

            System.out.print("Enter new contenido (leave empty to not change): ");
            String contenido = scanner.nextLine().trim();

            postService.update(id, title, contenido);

            System.out.println("Post updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deletePost(Scanner scanner) {
        try {
            System.out.print("Enter post id: ");
            int id = scanner.nextInt();

            postService.delete(id);

            System.out.println("Post deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void assignCategoryToPost(Scanner scanner) {
        try {
            System.out.print("Enter post id: ");
            int postId = scanner.nextInt();

            System.out.print("Enter categories (comma separated): ");
            String categoriesInput = scanner.nextLine();

            String[] categoryNames = categoriesInput.split(",");

            postService.setCategories(postId, categoryNames);

            System.out.println("Categories assigned successfully to the post.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// ====================================== CLIENTES =======================================
private static void createClient(Scanner scanner) {
    try {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();

        clientService.create(name);

        System.out.println("Client created successfully.");

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    private static void readClient(Scanner scanner) {
        try {
            System.out.print("Enter client id: ");
            int id = scanner.nextInt();

            Client client = clientService.get((long) id);

            if (client != null) {
                System.out.println(client);
            } else {
                System.out.println("Client not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateClient(Scanner scanner) {
        try {
            System.out.print("Enter client id: ");
            int id = scanner.nextInt();

            System.out.print("Enter new name (leave empty to not change): ");
            String name = scanner.nextLine().trim();

            clientService.update((long) id, name);

            System.out.println("Client updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteClient(Scanner scanner) {
        try {
            System.out.print("Enter client id: ");
            int id = scanner.nextInt();

            clientService.delete((long) id);

            System.out.println("Client deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // ======================================= CATEGORÍAS =======================================
    private static void createCategory(Scanner scanner) {
        try {
            System.out.print("Enter category name: ");
            String name = scanner.nextLine();

            categoryService.create(name);

            System.out.println("Category created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readCategory(Scanner scanner) {
        try {
            System.out.print("Enter category id: ");
            int id = scanner.nextInt();

            Category category = categoryService.get((long) id);

            if (category != null) {
                System.out.println();
            } else {
                System.out.println("Category not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateCategory(Scanner scanner) {
        try {
            System.out.print("Enter category id: ");
            int id = scanner.nextInt();

            System.out.print("Enter new name (leave empty to not change): ");
            String name = scanner.nextLine().trim();

            categoryService.update((long) id, name);

            System.out.println("Category updated successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteCategory(Scanner scanner) {
        try {
            System.out.print("Enter category id: ");
            int id = scanner.nextInt();

            categoryService.delete((long) id);

            System.out.println("Category deleted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}