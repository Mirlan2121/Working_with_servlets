package company;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Team barcelona = new Team("Barcelona", new Game());
        Team realMadrid = new Team("Real Madrid", new Game());
        Statistics statistics = new Statistics(barcelona, realMadrid);


        barcelona.setPriority(10);
        realMadrid.setPriority(10);
        statistics.setPriority(1);


        barcelona.start();
        realMadrid.start();
        statistics.start();

        // ИЗВИНИТЕ ЭТУ ДОМАШКУ ЯЯ ПОДГЛЯДОВАЛ У ЧИНГИЗ АКЕ ТАК КАК НЕ КАК ИМЕННО ДСЕЛАТЬ ПРОШУ ПРОШЕНИЕ

        /*
         1. Разница между потоком и процессом?
                Процесс - это объект для выполнения чего - то, а поток это определенный способ выполнения процесса.
            2. Какие есть состояния потока?
                - new -> поток создан, но не запущен.
                - Runnable -> поток к выполнению, но не выполняется.
                - Running -> поток выполняется.
                - Waiting/Sleeping -> поток ожидает/спит.
                - Dead -> поток завершен.
            3. Зачем isAlive()?
                Это функция для проверки, используется ли поток. Во всех случаях, вернет false, кроме Running.
            4. Зачем join()?
                Это функция заставляет ждать все потоки, пока не закончится выполнятся поток который вызвал ее.
            5. Что будет если вызвать new MyThread().run() напрямую без вызова start()?
                Просто вызовется сам метод в основном потоке (Main), не разделяя на отдельные потоки.
            6. Можно ли запустить один поток дважды?
                Нет нельзя.
            7. Что такое блок синхронизации?
                Блок синхронизации это часть кода, для избежания вмешивания одного потока в работу другого.
                Другими словами один поток может использовать эту часть когда, и пока он не закончит,
                другой не зайдет в нее.
         */
    }
}
