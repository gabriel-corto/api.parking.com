up:
	docker compose up --build

dev:
	./gradlew bootRun -t

test:
	./gradlew test