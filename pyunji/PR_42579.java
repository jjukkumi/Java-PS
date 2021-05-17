import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        /* 고유번호, 장르, 재생횟수가 들어있는 Music 객체 생성 */
        class Music {
            int id;
            String genre;
            int play;
            Music(int id, String genre, int play) {
                this.id = id;
                this.genre = genre;
                this.play = play;
            }

            public int getId() {
                return id;
            }

            public String getGenre() {
                return genre;
            }

            public int getPlay() {
                return play;
            }
        }

        /* Music객체를 저장하는 ArrayList 생성 */
        ArrayList<Music> musicArrayList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) musicArrayList.add(new Music(i, genres[i], plays[i]));
        /* Music객체를 재생 횟수가 많은 순서로 정렬 */
        musicArrayList.sort(Comparator.comparing(Music::getPlay).reversed());

        /* 장르를 key로 갖고 장르별 총 재생 횟수를 value로 갖는 Map을 생성 */
        Map<String, Integer> genPlMap = musicArrayList.stream()
                .collect(Collectors.groupingBy(Music::getGenre, Collectors.summingInt(Music::getPlay)));

        /* 재생 횟수가 많은 장르 순서로 장르이름을 저장한 리스트 생성 */
        List<String> genOrdList = genPlMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        /* 1. musicArrayList를 정렬된 genOrdList의 장르 이름 순으로 필터링한다.
        *  2. 2개의 Music객체만 골라낸다.
        *  3. Music객체의 id값만 가져와 새로운 ArrayList를 생성한다.
        *  4. collectIds에 추가한다. */
        ArrayList<Integer> collectIds = new ArrayList<>();
        for(String gen:genOrdList) {
            collectIds.addAll(musicArrayList.stream().filter(music -> music.getGenre().equals(gen)).limit(2)
                    .map(Music::getId).collect(Collectors.toCollection(ArrayList::new)));
        }
        return collectIds.stream().mapToInt(i -> i).toArray();
    }
}