package br.com.marlonsilva.desafiotodolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.marlonsilva.desafiotodolist.entity.todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DesafioTodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreatTodoSucess() {
		var Todo = new todo("todo 2", "desc todo 2", false, 1);

		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(Todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$.[0].nome").isEqualTo(Todo.getNome())
			.jsonPath("$.[0].descricao").isEqualTo(Todo.getDescricao())
			.jsonPath("$.[0].realizado").isEqualTo(Todo.isRealizado())
			.jsonPath("$.[0].prioridade").isEqualTo(Todo.getPrioridade());
	}

	@Test
	void testCreatTodoFailure() {
		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(
				new todo("", "", false, 0)
			).exchange()
			.expectStatus().isBadRequest();
	}

}
