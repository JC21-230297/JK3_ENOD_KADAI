package apiClass;

public interface CluDefinitionInterface {
	// モデルのデプロイ　→　予測 URL
	static final String apiUrl = "https://gyutan230297.cognitiveservices.azure.com/language/:analyze-conversations?api-version=2024-11-15-preview";
	
	//　プロジェクト設定　→　 主キー:
	static final String subscriptionKey = "9db2f0d08ffe4cfd9598e74ae25e01cb";
	
	// プロジェクトを見る
	static final String projectName = "gyutan230297";
	
	// モデルのデプロイを見る
	static final String deploymentName = "ryutanDeploy";
}
