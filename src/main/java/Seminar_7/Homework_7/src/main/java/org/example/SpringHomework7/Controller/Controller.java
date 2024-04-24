package org.example.SpringHomework7.Controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.example.SpringHomework7.Model.Book;
import org.example.SpringHomework7.Repository.Repository;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {
    //в контролер внедряем зависимость - репозиторий, а также добавляем
    //статические переменные выручки магазина и суммы покупки пользователя
    private final Repository repository;
    private static double revenue = 0.0;
    private static double purchase = 0.0;

    //по умолчанию отдаем страницу витрины магазина
    @GetMapping("/")
    public String getViewAsGuest(Model model) {
        model.addAttribute("books", repository.getBooks());
        return "showroom";
    }

    //отдаем страницу авторизации
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //отдаем страницу пользователя
    @GetMapping("/user-profile")
    public String getViewAsCommonUser(Model model) {
        model.addAttribute("books", repository.getBooks());
        model.addAttribute("purchase", purchase);
        return "user-profile";
    }

    //отдаем страницу администратора
    @GetMapping("/admin-profile")
    public String getViewAsAdmin(Model model) {
        model.addAttribute("books", repository.getBooks());
        model.addAttribute("revenue", revenue);
        return "admin-profile";
    }

    //отдаем обновленную страницу администратора после добавления новой книги
    @PostMapping("/admin-profile")
    public String addBook(Book book, Model model) {
        repository.addBook(book);
        model.addAttribute("books", repository.getBooks());
        return "redirect:/admin-profile";
    }

    //отдаем обновленную страницу администратора после продажи книги
    @GetMapping("book-sell/{name}")
    public String sellBook(@PathVariable("name") String name) {
        revenue += Math.round(repository.getBook(name).getPrice() * 100.0) / 100.0;
        repository.sellBook(name);
        return "redirect:/admin-profile";
    }

    //отдаем обновленную страницу пользователя после покупки книги
    @GetMapping("book-purchase/{name}")
    public String buyBook(@PathVariable("name") String name) {
        purchase += Math.round(repository.getBook(name).getPrice() * 100.0) / 100.0;
        revenue += Math.round(repository.getBook(name).getPrice() * 100.0) / 100.0;
        repository.sellBook(name);
        return "redirect:/user-profile";
    }
}
