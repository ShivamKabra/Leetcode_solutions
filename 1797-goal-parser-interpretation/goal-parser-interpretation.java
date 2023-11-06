class Solution {
    public String interpret(String command) {
        String interpreted = command.replaceAll("\\(\\)", "o");
        interpreted = interpreted.replaceAll("\\(al\\)", "al");

        return interpreted;
    }
}