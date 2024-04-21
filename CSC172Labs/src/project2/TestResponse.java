package project2;

public class TestResponse {

    public static void main(String[] args) {
        Response response = new Response(1, "M", 30, 1, 3, 2, 1, 1, 2022, "Some string", 1, 2, 3, 4, 1, 2, "Another string", 2, 3, 4, 1, 2, 3, "Yet another string", 3, 4, 1, 2, 3, 4, 5);

    // Display information from the Response object
        System.out.println("ID: " + response.getId());
        System.out.println("Gender: " + response.getGender());
        System.out.println("Age: " + response.getAge());
        System.out.println("Quality: " + response.getQuality());
        response.printResponse();
}
}

