up:
	docker compose up --build

dev:
	./gradlew bootRun -Dspring.profiles.active=dev

test:
	./gradlew test