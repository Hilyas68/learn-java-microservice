public class UserInput {
    public static class TextInput {
        String input;
        public void add(char c){
            String s = String.valueOf(c);
            if(input == null){
                input = s;
            }else {
                this.input = this.input.concat(s);
            }
        }

        public String getValue(){
            return this.input;
        }
    }

    public static class NumericInput extends TextInput {

        @Override
        public void add(char c) {
            if (Character.isDigit(c)) {
                String s = String.valueOf(c);
                if(input == null){
                    input = s;
                }else {
                    this.input = this.input.concat(s);
                }
            }
        }

        public static void main(String[] args) {
            TextInput input = new NumericInput();
            input.add('1');
            input.add('a');
            input.add('0');
            System.out.println(input.getValue());
        }
    }
}