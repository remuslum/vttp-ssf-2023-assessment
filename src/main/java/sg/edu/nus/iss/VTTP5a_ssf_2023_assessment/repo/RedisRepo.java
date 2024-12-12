package sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.model.Event;
import sg.edu.nus.iss.VTTP5a_ssf_2023_assessment.util.MyConstants;

@Repository
public class RedisRepo {
    @Autowired
    @Qualifier(MyConstants.TEMPLATE01)
    private RedisTemplate<String, String> redisTemplate;

    public void saveRecord(String redisKey, Event event){
        redisTemplate.opsForList().rightPush(redisKey, event.convertToJSONString());
    }

    public Long getNumberOfEvents(String redisKey){
        return redisTemplate.opsForList().size(redisKey);
    }

    public String get(String key, Integer index){
        return redisTemplate.opsForList().index(key, index);
    }
}
