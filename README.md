# Spring BootでWebエンドポイントをトリガーにして非同期処理を呼び出す

## 概要

次のcurlコマンドで処理を実行できる。
日時を渡しているが、処理対象のデータを抽出するときなどには処理内部で取得したシステム日付を使用するよりも、外部から渡されたパラメーターを使用する方がテストしやすい。
また、特定日時に対してアドホックに処理したい場合にも役立つ。

```
curl localhost:8080/fire -X POST -d dateTime=2020-03-13T06:02:59
```

コントローラーから非同期処理が呼び出されて、次のようなログが標準出力へ出る。

```
[start] trigger
[end] trigger
[start] batch process
parameter = 2020-03-13T06:02:59
[end] batch process
```

ちなみにコントローラーと非同期処理ではトランザクションが別れるので、コントローラーはあくまでも非同期処理を呼び出すだけに留めてDBアクセスはしない方が安全。

## Springの非同期処理

まず非同期処理を有効化する。
メインクラスに`@EnableAsync`を付ければOK。

それから非同期にしたいメソッドに`@Async`を付ける。
引数はそのまま受け取れる。

戻り値は少しルールがある。
今回は戻り値がないので`void`にしているけれど、戻り値がある場合は`java.util.concurrent.Future`で宣言する。
メソッドの実装としては返す値を`org.springframework.scheduling.annotation.AsyncResult`で包めばよい。

こんな感じ。

```java
@Async
public Future<String> asyncMethod() {
    String result = longLongTimeProcess();
    return AsyncResult.forValue(result);
}
```

