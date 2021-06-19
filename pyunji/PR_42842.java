class Solution{
    public int[] solution(int brown, int yellow) {
        int a = (brown + 4) / 2;    // width + height = (brown + 4) / 2
        int b = (brown + yellow);   // width * height = brown + yellow
        /* x1 = width
        * x2 = height
        * x^2 -(두 해의 합)x + (두 해의 곱) = 0
        * 근의 공식으로 x^2 - (a)x + b = 0의 해를 구하자 */
        int width = (int) (a + Math.sqrt(Math.pow(a, 2) - 4 * b)) / 2;
        int height = (int) (a - Math.sqrt(Math.pow(a, 2) - 4 * b)) / 2;
        return new int[]{width, height};
    }
}