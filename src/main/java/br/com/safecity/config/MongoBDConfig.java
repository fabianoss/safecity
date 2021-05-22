package br.com.safecity.config;

//@Configuration
//@EnableMongoRepositories(basePackages = "br.com.safecity.*")
public class MongoBDConfig {
	
	/*
	 * private static Logger logger = LogManager.getLogger(MongoBDConfig.class);
	 * 
	 * @Value("${mongo.safecity.host}") private String hosts;
	 * 
	 * @Value("${mongo.safecity.port}") private String port;
	 * 
	 * @Value("${mongo.safecity.database}") private String dataBase;
	 * 
	 * @Value("${mongo.safecity.username}") private String username;
	 * 
	 * @Value("${mongo.safecity.password}") private String password;
	 * 
	 * @Bean public MongoDatabaseFactory MongoDatabaseFactory(){
	 * 
	 * String database = this.dataBase;
	 * 
	 * MongoClient mongoClient = MongoClients.create( MongoClientSettings.builder()
	 * .applyToConnectionPoolSettings(builder -> builder .maxConnectionIdleTime(1000
	 * * 60 * 30, TimeUnit.MILLISECONDS) .maxWaitTime(15000, TimeUnit.MILLISECONDS)
	 * .maxSize(30) .build()) .applyToSocketSettings(builder -> builder
	 * .connectTimeout(15000, TimeUnit.MILLISECONDS) .build())
	 * .applyToClusterSettings(builder -> builder .serverSelectionTimeout(1000 * 15,
	 * TimeUnit.MILLISECONDS) .hosts(this.listServerAddress()) .build())
	 * .credential(this.getMongoCredential()) .build() ); return new
	 * SimpleMongoClientDatabaseFactory(mongoClient, database); }
	 * 
	 * @Bean public MongoTemplate mongoTemplate() throws UnknownHostException {
	 * MongoTemplate template = new MongoTemplate(MongoDatabaseFactory()); return
	 * template; }
	 * 
	 * private MongoCredential getMongoCredential() { String userName =
	 * this.username; String database = this.dataBase; String password =
	 * this.password; logger.info("userName {} ", userName);
	 * logger.info("database {} ", database); logger.info("password {} ", password);
	 * return MongoCredential.createCredential(userName, database,
	 * password.toCharArray()); }
	 * 
	 * private List<ServerAddress> listServerAddress() { String hosts = this.hosts;
	 * String port = this.port; logger.info("hosts {} ", hosts);
	 * logger.info("port {} ", port); List<ServerAddress> serversAddress = new
	 * ArrayList<>(); String[] servers = StringUtils.split(hosts, ","); for (String
	 * host : servers) { ServerAddress serverAddress = new ServerAddress(host,
	 * Integer.parseInt(port)); serversAddress.add(serverAddress); } return
	 * serversAddress; }
	 */
}
