package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"time"
)

func soma(x int, y int) (int, bool) {
	if x > 10 {
		return x + y, true
	}
	return x + y, false
}

func home(w http.ResponseWriter, r *http.Request) {
	course := Course{
		Name:        "Golang",
		Price:       100,
		Description: "Curso do Golang da Digital Innovation One.",
	}
	json.NewEncoder(w).Encode(course)
	w.Write([]byte("Hello, Mundo"))
}

type Course struct {
	Name        string `json:"name"`
	Price       int    `json:"price"`
	Description string `json:"description"`
}

func (c Course) GetFullInfo() string {
	return fmt.Sprintf("Name: %s, Description: %s, Price: %d", c.Name, c.Description, c.Price)
}

func counter() {
	for i := 0; i < 10; i++ {
		fmt.Println(i)
		time.Sleep(time.Second)
	}
}

func worker(workerid int, data chan int) {
	for x := range data {
		fmt.Printf("worker %d received %d\n", workerid, x)
		time.Sleep(time.Second)
	}
}

func main() {
	//Declarar a variável e já atribuir valor a ela
	a := "Hello, Mundo!!"

	//Depois de já criada, tudo segue como antes
	a = "Olá, World!!"
	println(a)
	println(soma(1, 3))

	resultado, status := soma(1, 3)
	println(resultado)
	println(status)

	fmt.Println("Hello, World!", resultado)

	course := Course{
		Name:        "Golang",
		Price:       100,
		Description: "Curso do Golang da Digital Innovation One.",
	}
	fmt.Println(course.Name)
	fmt.Println(course.GetFullInfo())

	go counter()
	go counter()
	go counter()

	channel := make(chan string)
	go func() {
		channel <- "Hello Channel!!"
	}()
	fmt.Println(<-channel)

	channel2 := make(chan int)
	for i := 0; i < 3; i++ {
		go worker(i, channel2)
	}
	for i := 0; i < 10; i++ {
		channel2 <- i
	}

	http.HandleFunc("/", home)
	http.ListenAndServe(":8080", nil)
}
